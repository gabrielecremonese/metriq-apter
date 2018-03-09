package com.solera.global.app.metriq.mongo.entity;

import lombok.Getter;

@Getter
public class MetricSwagger extends Metric {
	
	private String endPoint;
	

	public MetricSwagger(String name, String shortName, String endPoint) {
		super(name, shortName);
		this.endPoint = endPoint;
	}


	@Override
	public MetricStatus apply() {
		/*
		 * TODO
		 * Implement logic to call endPoint and check if swagger is responding.
		 * If true set status = green, otherwise red
		 */
		return MetricStatus.GREEN;
	}


}
