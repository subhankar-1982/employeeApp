package com.details.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfigDetail {

	    @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.details.employee.controller.*"))
	                .paths(PathSelectors.any())
	                .build().apiInfo(apiInfoMetaData());
	    }

	    private ApiInfo apiInfoMetaData() {

	        return new ApiInfoBuilder().title("API Documentation")
	                .description("This api consits of all Employee details with tax and allow to save employee details")
	                .contact(new Contact("Dev-Team", "https://www.subhankar.com/", "jobs.subhankar1982@gmail.com"))
	                .license("Apache 2.0")
	                .version("1.0.0")
	                .build();
	    }
}
