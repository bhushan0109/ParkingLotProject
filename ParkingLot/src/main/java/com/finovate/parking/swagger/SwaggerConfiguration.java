package com.finovate.parking.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	 @Bean
	    public Docket parkingLotApi() {
	        return new Docket(DocumentationType.SWAGGER_2).groupName("ParkingLot-api").apiInfo(apiInfo()).select()
	                .apis(RequestHandlerSelectors.basePackage(" com.finovate.parking.controller"))
	                .build();

	    }
	    
	 private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("ParkingLot service")
					.description("Documentation Generateed Using SWAGGER2 for ParkingLot API")
					.termsOfServiceUrl("https://github.com/bhushan0109/ParkingLotProject.git")
					.license("finovate capital License")
					.licenseUrl("https://github.com/bhushan0109/ParkingLotProject.git").version("1.0").build();
		}
	}

	//http://localhost:8080/swagger-ui.html#/

