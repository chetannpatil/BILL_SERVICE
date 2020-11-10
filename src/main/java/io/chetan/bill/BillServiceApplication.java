package io.chetan.bill;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class BillServiceApplication {

	//private static final Logger LOGGER = Logger.getLogger(BillServiceApplication.class.getName());
	
	private static Logger LOGGER = LogManager.getLogger(BillServiceApplication.class);

	@Bean
	public Sampler defaultSampler() 
	{
		LOGGER.info("\n\n BillServiceApplication - defaultSampler- \n\n");
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		LOGGER.info("\n\n BillServiceApplication - getRestTemplate- \n\n");
		
		return new RestTemplate();
	}
	
	public static void main(String[] args) 
	{
		
		LOGGER.info("\n\n\n BillServiceApplication main \n\n\n");
		SpringApplication.run(BillServiceApplication.class, args);
	}

}
