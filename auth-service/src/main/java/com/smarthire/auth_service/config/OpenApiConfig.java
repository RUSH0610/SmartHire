package com.smarthire.auth_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${openapi.server.url}")
    private String gatewayUrl;

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();
        server.setUrl(gatewayUrl);
        server.setDescription("SmartHire API Gateway");

        return new OpenAPI()

                .info(new Info()
                        .title("Authentication Service API")
                        .version("1.0")
                        .description("""
                                ## Getting Started

                                This service is used to register new users and authenticate existing users.

                                ### Available Endpoints

                                1. Use **POST /api/register** to create a new user account.

                                2. Use **POST /api/login** to authenticate and generate a JWT.

                                3. Copy the JWT token from the login response.

                                ### Next Step

                                Switch to any protected SmartHire microservice to authorize using the generated JWT and start testing the protected APIs.
                                """))

                .servers(List.of(server));
    }
}