package com.devx.demo.mongorepos;

import com.devx.demo.mongodocs.RuleDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface RulesRepository extends MongoRepository<RuleDTO,Integer>{
    public List<RuleDTO> findByProtocol(String protocol);
    public List<RuleDTO> findByTimestamp(Date timestamp);
}

