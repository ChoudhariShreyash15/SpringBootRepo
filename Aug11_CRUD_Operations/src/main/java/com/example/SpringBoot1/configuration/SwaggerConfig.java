package com.example.SpringBoot1.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configSwagger()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Bank APIs")
                        .summary("All the api's will be managed by here")
                        .version("3.5"));
    }
}
