package kafka

import (
	"encoding/json"
	"fmt"
	"github.com/Shopify/sarama"
	"os"
	"strings"
)

const (
	RULE_CHANGE_TOPIC = "ruleChangeTrigger"
	TEST_TOPIC        = "test"
)

func ProduceRuleChangeMessage(message interface{}) error {

	messageBuf, err := json.Marshal(message)
	if err != nil {
		fmt.Println("Error marshalling message.")
		return err
	}
	publishMessage(messageBuf, RULE_CHANGE_TOPIC)
	return nil
}

func publishMessage(data []byte, topic string) error {
	fmt.Println("Sending message to topic ", topic)
	addrs, config := getKafkaConfig()
	producer, err := sarama.NewSyncProducer(addrs, config)
	if err != nil {
		fmt.Println("Error trying to create sync Producer for kafka", err)
		return err
	}
	defer producer.Close()

	message := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: -1,
		Value:     sarama.ByteEncoder(data),
	}

	if _, _, sendError := producer.SendMessage(message); sendError != nil {
		fmt.Println("Failed to produce message: '", sendError, "' Message: '", string(data), "'")
	}
	return nil
}

func getKafkaConfig() ([]string, *sarama.Config) {
	kafkaHost := strings.TrimSpace(os.Getenv("KAFKA_HOST"))
	if kafkaHost == "" {
		fmt.Println("KAFKA_HOST not found")
		return nil, nil
	}

	kafkaPort := strings.TrimSpace(os.Getenv("KAFKA_PORT"))
	if kafkaPort == "" {
		kafkaPort = "9092"
	}

	addrs := []string{kafkaHost + ":" + kafkaPort}
	config := sarama.NewConfig()
	config.Producer.RequiredAcks = sarama.WaitForAll
	config.Producer.Partitioner = sarama.NewRandomPartitioner
	config.Producer.Return.Successes = true

	return addrs, config
}
