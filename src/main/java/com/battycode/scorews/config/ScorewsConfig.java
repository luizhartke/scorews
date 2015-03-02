package com.battycode.scorews.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.battycode.scorews")
public class ScorewsConfig {
	public static void main(String[] args) {
		SpringApplication.run(ScorewsConfig.class, args);
	}
}
