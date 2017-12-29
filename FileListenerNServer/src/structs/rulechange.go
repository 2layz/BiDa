package structs

import "time"

type FileContent struct {
	Content   string    `json:"contents"` 
	Timestamp time.Time `json:"timestamp"`
}
