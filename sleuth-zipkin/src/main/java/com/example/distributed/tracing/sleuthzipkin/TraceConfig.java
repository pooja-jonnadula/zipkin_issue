package com.example.distributed.tracing.sleuthzipkin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class TraceConfig {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	

}
