package com.devx.rule.parser.kafka;

import com.devx.kafka.KafkaConsumerClient;
import com.devx.rule.parser.burp.BurpRuleParser;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class RulesKafkaConsumer extends KafkaConsumerClient {

    @Autowired
    private BurpRuleParser burpRuleParser;

    private static final String DEVX_RULES_KAFKA_CONSUMER_NAME = "BURP_RULE_CONSUMERS";

    @PostConstruct
    public void init() throws InterruptedException{
        String topic = System.getenv("DEVX_RULES_KAFKA_TOPIC");
        System.out.println("TOPIC -> "+topic);
        String bootstrapServers = System.getenv("DEVX_KAFKA_SERVICE_HOST")+":"+System.getenv("DEVX_KAFKA_SERVICE_PORT");
        System.out.println("Bootstrap -> "+bootstrapServers);
        String consumerName = DEVX_RULES_KAFKA_CONSUMER_NAME;
        System.out.println("Name -> "+consumerName);
        this.setBootstrapServers(bootstrapServers);
        this.setConsumerName(consumerName);
        this.setTopic(topic);
        try {
            startConsumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(100);
        } catch (Exception e){
            e.printStackTrace();
            Thread.sleep(300000);
        }
    }

    @Override
    public void processMessage(ConsumerRecord record) throws IOException {
        super.processMessage(record);
        burpRuleParser.processMessage(record);
    }

}
