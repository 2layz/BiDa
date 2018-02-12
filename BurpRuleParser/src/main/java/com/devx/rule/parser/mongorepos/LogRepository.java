package com.devx.rule.parser.mongorepos;

import com.devx.rule.parser.com.devx.rule.dto.LogStashDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogStashDTO,Integer>{}

