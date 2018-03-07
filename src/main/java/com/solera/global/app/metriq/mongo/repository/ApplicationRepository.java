package com.solera.global.app.metriq.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.solera.global.app.metriq.mongo.entity.Application;

public interface ApplicationRepository extends MongoRepository<Application, String> {
	
	public Application findByName(String name);
	public Application findByShortName(String shortName);

}
