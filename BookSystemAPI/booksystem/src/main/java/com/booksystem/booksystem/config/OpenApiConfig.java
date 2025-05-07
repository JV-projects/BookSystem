package com.booksystem.booksystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "BookSystem API",
                version = "1.0",
                description = "API para controle e gerenciamento de livros e empréstimos"
        )
)
@Configuration
public class OpenApiConfig {
}
