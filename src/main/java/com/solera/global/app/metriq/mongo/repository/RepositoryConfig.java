package com.solera.global.app.metriq.mongo.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.solera.global.app.metriq.mongo.repository")
@EnableMongoAuditing
public class RepositoryConfig {

}
