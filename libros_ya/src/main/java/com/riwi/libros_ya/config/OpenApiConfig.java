package com.riwi.libros_ya.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Api para Endpoints LibrosYa",
                version = "1.0",
                description = "Esta api se utiliza para visualizar Endpoints de LibrosYa"

        )
)
public class OpenApiConfig {
}
