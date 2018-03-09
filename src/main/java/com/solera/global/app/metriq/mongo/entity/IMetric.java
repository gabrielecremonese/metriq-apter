package com.solera.global.app.metriq.mongo.entity;

public interface IMetric {
	
	public MetricStatus getMetricStatus();
	
	public void setMetricStatus(MetricStatus metricStatus);
	
	public MetricStatus apply();
}
