package hospitalmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hospitalManagerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital Manager API")
                        .version("1.0")
                        .description("Hospital Management System REST APIs"));
    }
}