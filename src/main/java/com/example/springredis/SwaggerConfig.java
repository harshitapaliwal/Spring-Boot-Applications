package com.example.springredis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String Swagger_Api_version = "1.0";
	private static final String LICENSE = "License";
	private static final String title = "Employee API";
	private static final String description = "API for Employees";
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
		.title(title)
		.description(description)
		.license(LICENSE)
		.version(Swagger_Api_version)
		.build();
	}
	@Bean
	public Docket EmployeeApi(){
	
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths(PathSelectors.regex("/.*")).build();
	}
}
