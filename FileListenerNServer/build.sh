echo "Building Filewatcher go binary..."
CGO_ENABLED=0 go build -a -ldflags '-s' -o target/fileWatcher src/main/main.go
