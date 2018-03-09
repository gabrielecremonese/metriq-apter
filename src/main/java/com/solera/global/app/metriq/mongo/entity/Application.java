package com.solera.global.app.metriq.mongo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
	
	@Id
	private String id;
	
	private String name;
	private String shortName;
	
	private List<IMetric> metricList;
	
	public Application(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
		metricList = new ArrayList<IMetric>();
	}

	public void addMetric(IMetric metric) {

		metricList.add(metric);
		
	}

}
