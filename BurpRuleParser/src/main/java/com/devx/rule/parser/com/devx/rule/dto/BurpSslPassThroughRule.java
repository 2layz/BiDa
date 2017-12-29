package com.devx.rule.parser.com.devx.rule.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class BurpSslPassThroughRule {

    @Field("ruleEnabled")
    boolean enabled;

    String file;

    @Field("dstHost")
    String host;

    @Field("dstPort")
    String port;

    String protocol;

    public boolean isEnabled() {
        return enabled;
    }

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
