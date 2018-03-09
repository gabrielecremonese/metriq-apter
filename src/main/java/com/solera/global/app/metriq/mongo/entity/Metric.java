package com.solera.global.app.metriq.mongo.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public abstract class Metric implements IMetric {
	
	@Id
	private String id;
	
	private String name;
	private String shortName;
	
	private MetricStatus metricStatus;
	
	public Metric(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	public void setMetricStatus(MetricStatus metricStatus) {
		this.metricStatus = metricStatus;
	}
	
}
