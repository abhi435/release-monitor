package com.demo.releasemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.demo.*")
public class ReleaseMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReleaseMonitorApplication.class, args);
	}

}