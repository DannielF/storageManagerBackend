package com.sofka.tz.backend.storagemanager.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.sofka.tz.backend.storagemanager",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".+UseCase$")})
public class UseCasesConfiguration {
}
