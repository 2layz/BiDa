package com.devx.demo.mongodocs;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class RuleDTO {
    private String protocol;
    private String host;
    private String enabled;
    private String file;
    private String port;
    private Date timestamp;
    private String ruleID;

    public RuleDTO(String protocol, String host, String enabled, String file, String port, Date timestamp) {
        this.protocol = protocol;
        this.host = host;
        this.enabled = enabled;
        this.file = file;
        this.port = port;
        this.timestamp =timestamp;
        setRuleID(protocol + host + port);
    }

    public Date getTimestamp() { return timestamp; }

    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public String getProtocol() { return protocol; }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRuleID() { return ruleID; }

    public void setRuleID(String ruleID) { this.ruleID = ruleID; }
}
