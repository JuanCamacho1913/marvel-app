package com.api.marvel.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API MARVEL",
                description = "Aplication for Marvel",
                termsOfService = "www.apimarvel.com/terminosYCondiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Juan Esteban Camacho",
                        url = "www.apiMarvell.com",
                        email = "jecb1913@gmail.com"
                ),
                license = @License(
                        name = "Licencia estandar de uso de software",
                        url = "www.apiMarvell.com/license",
                        identifier = "66.25.10.34.6"
                )
        ),
        servers ={
                @Server(
                        url = "http://localhost:8080",
                        description = "DEV SERVER"
                ),
                @Server(
                        url = "http://creacionestalentosos:8080",
                        description = "PROD SERVER"
                )
        },
        security = @SecurityRequirement(
                name = "Security token"
        )
)
@SecurityScheme(
        name = "Security token",
        description = "Access token for my Api",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
