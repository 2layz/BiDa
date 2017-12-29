package com.devx.rule.parser.com.devx.rule.dto;

import java.util.Date;

public class Message {
    public String contents;
    public Date timestamp;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
