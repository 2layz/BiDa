package com.devx.rule.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.devx.rule.parser"})
public class RuleChangeListenerApp {

    public static void main(String ... args){
        SpringApplication.run(RuleChangeListenerApp.class, args);
    }
}
