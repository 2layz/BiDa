package com.devx.demo.clients;

import com.devx.demo.mongodocs.Rule;
import com.devx.demo.mongorepos.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class RulesRestClient {

    @Autowired
    RulesRepository rulesRepository;

    @RequestMapping("/get/rules")
    public List<Rule> getRules(){
        if (rulesRepository == null){
            System.out.println("Repo is null !");
            System.out.println("Check connection to DB !");
            return new ArrayList<Rule>();
        }else if(rulesRepository.findAll()==null){
            System.out.println("Nothing to show here !");
            return new ArrayList<Rule>();
        }
        return rulesRepository.findAll();
    }

    /*@RequestMapping("/add/samplerule")
    public String addRules(){
       Rule newRule = new Rule(new Random().nextInt(),"10.12.3","10.13.3","80","Allow" ,new Date());
       rulesRepository.save(newRule);
       return "Added sample Rule !";
    }*/

}
