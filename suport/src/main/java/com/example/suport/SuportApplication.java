package com.example.suport;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@Configuration
@EnableWebMvc
@EnableDubbo
@MapperScan("com.example.suport.mapper")
public class SuportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuportApplication.class, args);
	}

}
