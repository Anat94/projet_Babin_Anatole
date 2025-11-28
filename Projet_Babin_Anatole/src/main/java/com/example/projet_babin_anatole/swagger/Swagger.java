package com.example.projet_babin_anatole.swagger;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI simpleCashOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SimpleCash SI API")
                        .description("Documentation de l'API de gestion bancaire SimpleCash.")
                        .version("v4.0"));
    }
}