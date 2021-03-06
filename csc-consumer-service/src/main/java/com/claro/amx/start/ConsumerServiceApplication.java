package com.claro.amx.start;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import brave.sampler.Sampler;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class ConsumerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}
	
//	@Bean 
//	public Sampler defaultSampler() {
//		return Sampler.ALWAYS_SAMPLE;
//	}

}

@RestController
@RefreshScope
class Consumer {
	
	private static Logger LOG = LoggerFactory.getLogger(Consumer.class);
	
	@Value("${message}")
	private String message;

	@Value("${global-message}")
	private String globalMessage;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, String> message() {
		
		LOG.info("Dentro de csc-consumer-service.");
		
		Map<String, String> response = new HashMap<>();

		response.put("message", message);
		response.put("global-message", globalMessage);

		return response;
	}
	
}



