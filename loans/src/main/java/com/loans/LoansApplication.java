package com.loans;

import com.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.loans.controller") })
@EnableJpaRepositories("com.loans.repository")
@EntityScan("com.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "SysoievB",
                        email = "someemail@mail.com",
                        url = "https://www.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Loans microservice REST API Documentation",
                url = "https://www.com/swagger-ui.html"
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }
}
