package filewatcher

import (
	"encoding/csv"
	"filepublisher"
	"fmt"
	"github.com/fsnotify/fsnotify"
	"os"
	"strings"
)

var DATA_DIR_ENV string = "RULES_DATA_DIR"
var FILES_2_WATCH string = "FILES_2_WATCH"

func StartWatching() {
	//data_dir := os.Getenv(DATA_DIR_ENV);

	watcher, err := fsnotify.NewWatcher()
	if err != nil {
		fmt.Println("error: ", err)
	}
	defer watcher.Close()

	done := make(chan bool)
	go func() {
		for {
			select {
			case event := <-watcher.Events:
				fmt.Println("event:", event)
				if event.Op&fsnotify.Write == fsnotify.Write {
					fmt.Println("modified file:", event.Name)
					filepublisher.PublishFile(event.Name)
				}
			case err := <-watcher.Errors:
				fmt.Println("error:", err)
			}
		}
	}()

	addWatchers(watcher)

	<-done
}

func addWatchers(watcher *fsnotify.Watcher) {
	fileList := os.Getenv(FILES_2_WATCH)
	reader := csv.NewReader(strings.NewReader(fileList))

	files, err := reader.Read()
	if err != nil {
		fmt.Println("error:", err)
	}

	for _, file := range files {
		fmt.Println("Listening for file changes in ", file)
		err = watcher.Add(file)
		if err != nil {
			fmt.Println("error:", err)
		}
	}
}
