package com.devx.demo.mongorepos;

import com.devx.demo.mongodocs.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RulesRepository extends MongoRepository<Rule,Integer>{}

