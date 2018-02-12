package com.devx.rule.parser.mongorepos;

import com.devx.rule.parser.com.devx.rule.dto.RuleDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RulesRepository extends MongoRepository<RuleDTO,Integer>{}

