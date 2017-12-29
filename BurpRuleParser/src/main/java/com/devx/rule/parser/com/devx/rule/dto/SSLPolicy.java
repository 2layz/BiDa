package com.devx.rule.parser.com.devx.rule.dto;

public class SSLPolicy {

    BurpSslPassThroughRule[] rules;
    Boolean automatically_add_entries_on_client_ssl_negotiation_failure;

    public BurpSslPassThroughRule[] getRules() {
        return rules;
    }

    public void setRules(BurpSslPassThroughRule[] rules) {
        this.rules = rules;
    }

    public Boolean getAutomatically_add_entries_on_client_ssl_negotiation_failure() {
        return automatically_add_entries_on_client_ssl_negotiation_failure;
    }

    public void setAutomatically_add_entries_on_client_ssl_negotiation_failure(Boolean automatically_add_entries_on_client_ssl_negotiation_failure) {
        this.automatically_add_entries_on_client_ssl_negotiation_failure = automatically_add_entries_on_client_ssl_negotiation_failure;
    }
}
