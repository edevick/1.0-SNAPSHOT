package com.sytoss.app;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
@ComponentScan
public class Application {
	private static final Logger LOGGER = getLogger(Application.class);
	public static void main(String[] args) {
		LOGGER.debug("Starting REST Client!!!!");
		SpringApplication.run(Application.class, args);
	}

}
