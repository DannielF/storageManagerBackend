package com.sofka.tz.backend_storagemanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Storage Manager", version = "1.0", description = "Documentation APIs v1.0"))
public class BackendStorageManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendStorageManagerApplication.class, args);
    }

}
