package com.hendisantika.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hendisantika.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Spring Boot OAuth2 - Public OAuth",
                "Documentation of project Spring Boot OAuth2",
                "1.0.0",
                "Terms of service by BENGKEL ROBOT",
                new Contact("BENGKEL ROBOT", "http://bengkelrobot.net", "kolonel.yudisetiawan@gmail.com"),
                "License of API is BENGKEL ROBOT",
                "-"
        );
    }

}
