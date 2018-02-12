package com.devx.rule.parser.com.devx.rule.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * Created by fiahamed on 09-02-2018.
 */

@Document
public class RuleDTO {
    String RuleID;

    boolean enabled;

    String file;

    String host;

    String port;

    String protocol;

    private Date timestamp;

    private RuleDTO(){}

    public RuleDTO(BurpSslPassThroughRule BSR, Date timestamp){
        this.timestamp = timestamp;
        setEnabled(BSR.isEnabled());
        setFile(BSR.getFile());
        setHost(BSR.getHost());
        setPort(BSR.port);
        setProtocol(BSR.protocol);
        setRuleID(getProtocol() + getHost() + getPort());
    }

    public String getRuleID() { return RuleID; }

    public void setRuleID(String ruleID) { RuleID = ruleID; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
