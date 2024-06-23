package com.altimetrik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/accounts/**")
                        .uri("lb://account-service"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .route("reporting-service", r -> r.path("/reports/**")
                        .uri("lb://reporting-service"))
                .build();
    }
}