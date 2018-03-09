package com.solera.global.app.metriq.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.global.app.metriq.mongo.entity.Application;
import com.solera.global.app.metriq.mongo.entity.IMetric;
import com.solera.global.app.metriq.mongo.entity.IMetricSet;
import com.solera.global.app.metriq.mongo.entity.MetricSwagger;
import com.solera.global.app.metriq.mongo.entity.MetricSwaggerSet;
import com.solera.global.app.metriq.mongo.repository.ApplicationRepository;

@Service
public class MetricConfigurationService {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	private static final String CONFIGURATION_PATH = "src/main/resources/config/app";

	private static final String NAME = "name";
	private static final String SHORT_NAME = "short.name";
	
	private static final String METRIC_SWAGGER_LIST = "metric.swagger.list";
	private static final String METRIC_SWAGGER_SHORT_NAME = "metric.swagger.short.name.";
	private static final String METRIC_SWAGGER_NAME = "metric.swagger.name.";
	private static final String METRIC_SWAGGER_ENDPOINT = "metric.swagger.endpoint.";
	

	public void loadConfigurations() {
		
		File root = new File(CONFIGURATION_PATH);		
		File[] fileList = root.listFiles();
		File current = null;
		
		for (int i = 0; i < fileList.length; i++) {
			try {
				current = fileList[i];
				Properties properties = loadConfiguration(current);
				saveApplication(properties);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}

	private Properties loadConfiguration(File file) throws IOException {
		
		Properties properties = new Properties();
		InputStream inputStream =  new FileInputStream(file);
		properties.load(inputStream);
		
		if(inputStream != null) {
			inputStream.close();
		}
		
		return properties;
		
	}
	
	private void saveApplication(Properties properties) {
		
		String name = properties.getProperty(NAME);
		String shortName = properties.getProperty(SHORT_NAME);
		Application application = new Application(name, shortName);		
		
		String[] swaggerList = properties.getProperty(METRIC_SWAGGER_LIST).split(",");
		
		IMetric swaggerMetric = retrieveSwaggerMetrics(properties, swaggerList);
		
		application.addMetric(swaggerMetric);
		
		applicationRepository.save(application);
		
	}

	private IMetric retrieveSwaggerMetrics(Properties properties, String[] swaggerList) {
		
		//TODO read greenPercentage, yellowPercentage from file
		
		IMetricSet result = new MetricSwaggerSet(100, 100);
		
		for (int i = 0; i < swaggerList.length; i++) {
			
			IMetric metric= retrieveSwaggerMetric(properties, swaggerList[i]);
			result.add(metric);
		}

		return result;
	}

	private IMetric retrieveSwaggerMetric(Properties properties, String swaggerPropertySuffix) {

		String name = properties.getProperty(METRIC_SWAGGER_NAME + swaggerPropertySuffix);
		String shortName = properties.getProperty(METRIC_SWAGGER_SHORT_NAME + swaggerPropertySuffix);
		String endPont = properties.getProperty(METRIC_SWAGGER_ENDPOINT + swaggerPropertySuffix);
		
		IMetric metric = new MetricSwagger(name, shortName, endPont);
		
		return metric;
	}
	
}
