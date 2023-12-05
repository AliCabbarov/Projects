package com.library.libmanagesys.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "library management system",
        description = "lorem ipsum",
        contact = @Contact(name = "cabbarovali",email = "ali.cab@div.edu.az"),
        version = "1.0.0"
))
public class SwaggerConfig {
}
