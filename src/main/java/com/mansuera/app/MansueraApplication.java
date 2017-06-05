package com.mansuera.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mansuera"})
@Configuration
public class MansueraApplication extends BaseConfig {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3924543054339126835L;

	public static void main(String[] args) {
		SpringApplication.run(MansueraApplication.class, args);
	}
}
