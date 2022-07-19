package com.example.SMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class SmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

}
