package com.devx.rule.parser.com.devx.rule.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class DBRules{

    Date timestamp;

    @Field("sslRules")
    BurpSslPassThroughRule[] sslRules;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BurpSslPassThroughRule[] getSslRules() {
        return sslRules;
    }

    public void setSslRules(BurpSslPassThroughRule[] sslRules) {
        this.sslRules = sslRules;
    }
}
