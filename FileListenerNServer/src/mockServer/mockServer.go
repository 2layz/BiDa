package main

import (
	"filewatcher"
	"fmt"
	"net/http"
	"os"
)

func main() {
	datadir := os.Getenv(filewatcher.DATA_DIR_ENV)
	fs := http.FileServer(http.Dir(datadir))
	http.Handle("/static/", http.StripPrefix("/static/", fs))
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Hello! try /static/<filename>\n")
	})

	go filewatcher.StartWatching()

	fmt.Println("Listening...")
	http.ListenAndServe(":8080", nil)

}
