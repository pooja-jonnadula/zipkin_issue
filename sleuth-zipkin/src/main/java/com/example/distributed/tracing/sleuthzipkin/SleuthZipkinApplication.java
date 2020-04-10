package com.example.distributed.tracing.sleuthzipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@SpringBootApplication
public class SleuthZipkinApplication {
Logger log=LoggerFactory.getLogger(SleuthZipkinApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SleuthZipkinApplication.class, args);
	}

	@GetMapping("/")
	public String hiTrace() {
		log.info("hi we r in side tracing");
		return "Example for Tracing ID,span ID";
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/call")
	public String callHiTrace() {
		log.info("hi we r in side tracing inside");
		return "CALL::"+restTemplate.getForObject("http://localhost:9999/", String.class);
	}
}
