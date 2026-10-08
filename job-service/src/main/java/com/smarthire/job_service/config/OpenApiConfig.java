package com.smarthire.job_service.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
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

        final String securitySchemeName = "Bearer Authentication";

        return new OpenAPI()

                .info(new Info()
                        .title("Job Service API")
                        .version("1.0")
                        .description("""
                                ## Before Testing Protected APIs

                                ### One-Time Setup (Skip if Already Completed)

                                1. Select **Authentication Service** from the service dropdown.

                                2. Register a new user using **POST /api/register** (skip this step if you already have an account).

                                3. Login using **POST /api/login** with your registered credentials.

                                4. Copy the JWT token from the response.

                                ### Next Step

                                5. Switch to the **Job Service** from the service dropdown.

                                6. Click the **Authorize** button.

                                7. Paste the JWT token into the authorization field.

                                8. Click **Authorize**.

                                9. Close the authorization dialog.

                                > **Important:** You only need to authorize once. Swagger persists your JWT, so the same token is automatically used across all protected SmartHire microservices until it expires.

                                10. You can now test any protected API endpoint.
                                """))

                .servers(List.of(server))

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                )

                .components(
                        new Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}