package com.example.Api_Gateway.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Permitir todos los orígenes
//        config.setAllowedOriginPatterns(List.of("*"));
//        // Configurar los métodos permitidos
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//        // Permitir credenciales
//        config.setAllowCredentials(true);
//        // Permitir los encabezados necesarios
//        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}
