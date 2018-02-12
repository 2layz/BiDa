package com.devx.rule.parser.burp;

import com.devx.rule.parser.com.devx.rule.dto.*;
import com.devx.rule.parser.mongorepos.RulesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class BurpRuleParser {

    @Autowired
    RulesRepository rulesRepository;

    public BurpRuleParser() {
        System.out.println("Initializing BurpRuleParser...");
    }

    public void processMessage(ConsumerRecord record) throws IOException {
        String rulesContent = record.value().toString();
        rulesContent = rulesContent.replace("\\n", "")
                .replace("\\t", "");

        ObjectMapper mapper = new ObjectMapper();
        Message msg = mapper.readValue(rulesContent, Message.class);
        Contents content = mapper.readValue(msg.getContents(), Contents.class);
        Date changeTimestamp = msg.getTimestamp();
        BurpSslPassThroughRule[] rules = content.getProxy().getSsl_pass_through().getRules();

        for (BurpSslPassThroughRule rule : rules) {
            rulesRepository.save(new RuleDTO(rule, changeTimestamp));
        }
        System.out.println("Pushed rules to DB");
    }
}
