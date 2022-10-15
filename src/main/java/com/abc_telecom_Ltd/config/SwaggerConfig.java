package com.abc_telecom_Ltd.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Bean
    Docket redditCloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Complaint Box")
                .version("1.0")
                .description("API for Complaint Box Application")
                .contact(new Contact("Vishal Chhadekar", 
                		"https://github.com/VishalChhadekar", 
                		"vishalchhadekar95@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }

}
