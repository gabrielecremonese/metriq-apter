package com.solera.global.app.metriq.mongo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class MetricSet extends ArrayList<IMetric> implements IMetricSet{

	private static final long serialVersionUID = -998702577549109307L;
	
	private int greenPercentage;
	private int yellowPercentage;
	private MetricStatus metricStatus;

	public MetricSet(int greenPercentage, int yellowPercentage) {
		super();
		this.greenPercentage = greenPercentage;
		this.yellowPercentage = yellowPercentage;
	}
	
	@Override
	public MetricStatus getMetricStatus() {

		return metricStatus;
	}

	@Override
	public MetricStatus apply() {
		
		MetricStatus result = MetricStatus.RED;
		
		Map<MetricStatus, Integer> metricStatusCount = new HashMap<MetricStatus, Integer>();
		metricStatusCount.put(MetricStatus.GREEN, 0);
		metricStatusCount.put(MetricStatus.YELLOW, 0);
		metricStatusCount.put(MetricStatus.RED, 0);
		
		for (IMetric metric : this) {
			
			MetricStatus status = metric.apply();
			metricStatusCount.put(status, metricStatusCount.get(status)+1); 
			
		}
		
		if(metricStatusCount.get(MetricStatus.GREEN)/this.size()*100 >= greenPercentage) {
			result = MetricStatus.GREEN;
		}else if(metricStatusCount.get(MetricStatus.GREEN)/this.size()*100 >= yellowPercentage) {
			result = MetricStatus.YELLOW;
		}
		
		return result;
	}

	@Override
	public void setMetricStatus(MetricStatus metricStatus) {
		
		this.metricStatus = metricStatus;
		
	}

}
