package com.example.productInfoMS.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;


@Component
@RefreshScope
public class PriceClient {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceClient.class);
	

	@Value("${priceServiceName:PRICEINFOMS}")
	private String priceServiceName;	
   
	@Autowired
	private EurekaClient discoveryClient;

	public String getServiceUrl() {
		
		logger.info("priceServiceName is===="+priceServiceName);
		
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka(priceServiceName, false);
	        
	    
	   
	    return instance.getHomePageUrl();
	    
	}

}
