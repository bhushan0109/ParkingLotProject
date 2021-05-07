package com.finovate.parking.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/car.*"));
	//return or(regex("/car*"), regex("/XYZ.*"));		//FOR TWO controller
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ParkingLot service")
				.description("Documentation Generateed Using SWAGGER2 for ParkingLot API")
				.termsOfServiceUrl("https://github.com/bhushan0109/ParkingLotProject.git")
				.license("finovate capital License").licenseUrl("https://github.com/bhushan0109/ParkingLotProject.git")
				.version("1.0").build();
	}
}

// http://localhost:8080/swagger-ui.html#/
