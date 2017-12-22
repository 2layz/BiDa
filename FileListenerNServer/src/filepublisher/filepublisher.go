package filepublisher

import (
	"fmt"
	"io/ioutil"
	"kafka"
	"structs"
	"time"
)

func PublishFile(fileName string) error {
	fmt.Println("Trying to publish file... ", fileName)
	fileContents, err := readFile(fileName)
	if err != nil {
		fmt.Println("Unable to read file ", fileName, err)
		return err
	}

	return publishFileContents(fileContents)

}

func readFile(fileName string) (string, error) {
	byteContent, err := ioutil.ReadFile(fileName)
	if err != nil {
		return "", nil
	}
	return string(byteContent), nil
}

func publishFileContents(fileContents string) error {
	fileContent := new(structs.FileContent)
	fileContent.Content = fileContents
	fileContent.Timestamp = time.Now().UTC()
	return kafka.ProduceRuleChangeMessage(fileContent)
}
