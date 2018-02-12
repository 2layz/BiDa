package com.devx.demo.clients;

import com.devx.demo.mongodocs.RuleDTO;
import com.devx.demo.mongorepos.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RulesRestClient {

    @Autowired
    RulesRepository rulesRepository;

    @RequestMapping("/get/rules")
    public List<RuleDTO> getRules(){
        if (rulesRepository == null){
            System.out.println("Repo is null !");
            System.out.println("Check connection to DB !");
            return new ArrayList<RuleDTO>();
        }else if(rulesRepository.findAll()==null){
            System.out.println("Nothing to show here !");
            return new ArrayList<RuleDTO>();
        }
        return rulesRepository.findAll();
    }

    @RequestMapping("/add/TCP")
    public String addTCPRule(){
        RuleDTO newRule = new RuleDTO("TCP","10.12.3","true","default","80" ,new Date());
        rulesRepository.save(newRule);
        return "Added TCP sample Rule !";
    }

    @RequestMapping("/add/UDP")
    public String addUDPRule(){
        RuleDTO newRule = new RuleDTO("UDP","10.12.3","true","default","80" ,new Date());
        rulesRepository.save(newRule);
        return "Added UDP sample Rule !";
    }

    @RequestMapping("/get/counts")
    public String getCounts(){
        List<RuleDTO> tcpRList = rulesRepository.findByProtocol("TCP");
        List<RuleDTO> udpRList = rulesRepository.findByProtocol("UDP");
        return String.format("UDP: %s TCP: %s" , udpRList.size(), tcpRList.size());
    }

    @RequestMapping("/delAllRules")
    public String delRules(){
        rulesRepository.deleteAll();
        return String.format("Deleted all Rules !");
    }

    @RequestMapping("/get/forTimestamp/{ts}")
    public List<RuleDTO> getRuleForTS(@PathVariable("ts") long ts){
        return rulesRepository.findByTimestamp(Date.from(Instant.ofEpochMilli(ts))) ;
    }

    @RequestMapping("/get/countForTimestamp/{ts}")
    public int getCountForTS(@PathVariable("ts") long ts){
        return rulesRepository.findByTimestamp(Date.from(Instant.ofEpochMilli(ts))).size() ;
    }

    @RequestMapping("/get/timestamps")
    @Produces()
    public String getUniqTS(){
        Set<Long> uniqTS = new LinkedHashSet<>();
        List<RuleDTO> rList = rulesRepository.findAll();
        for (RuleDTO rl:rList ){
            if (null!=rl.getTimestamp()) uniqTS.add(rl.getTimestamp().toInstant().toEpochMilli() );
        }
        List<String> allTS = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<HTML><BODY>");
        for (Long ts: uniqTS){
            sb.append(ts+" : "+Date.from(Instant.ofEpochMilli(ts)).toString()+"</br>");
        }
        sb.append("</BODY></HTML>");

        return sb.toString();
    }
}
