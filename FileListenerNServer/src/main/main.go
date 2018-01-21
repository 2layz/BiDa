package main

import (
	"filewatcher"
	"fmt"
	"net/http"
	"os"
)

func handleMetrics(w http.ResponseWriter, r *http.Request) {
    fmt.Println("----------------  Servicing metrics request  --------------")
    msg := 10
    fmt.Fprintf(w, "# TYPE msg gauge\nmsg %d\n" , msg )
}

func main() {
	datadir := os.Getenv(filewatcher.DATA_DIR_ENV)
	role := os.Getenv("ROLE")
        fmt.Println("ROLE   --------------> "+role)

        if role == "fileserver"{
   	   fs := http.FileServer(http.Dir(datadir))
	   http.Handle("/static/", http.StripPrefix("/static/", fs))
	   http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Hello! try /static/<filename>\n")
	   })

        }


	if role == "publisher" {
           fmt.Println("Starting PUBLISHER...")
	   http.HandleFunc("/metrics/", func(w http.ResponseWriter, r *http.Request) {
    		fmt.Println("----------------  Servicing metrics request  --------------")
    		msg := 10
    		fmt.Fprintf(w, "# TYPE msg gauge\nmsg %d\n" , msg )

	   })
	   go filewatcher.StartWatching()
	}
	fmt.Println("Listening...")
	http.ListenAndServe(":8080", nil)

}
