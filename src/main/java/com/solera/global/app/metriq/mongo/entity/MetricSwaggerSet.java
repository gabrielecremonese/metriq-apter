package com.solera.global.app.metriq.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Data
@EqualsAndHashCode(callSuper=false)
public class MetricSwaggerSet extends MetricSet{

	private static final long serialVersionUID = -6919216678672472429L;

	public MetricSwaggerSet(int greenPercentage, int yellowPercentage) {
		super(greenPercentage, yellowPercentage);
	}

	

}
