package com.wevibe.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/users").allowedOrigins("http://localhost:3000");
//                registry.addMapping("/login").allowedOrigins("http://localhost:3000");
//                registry.addMapping("/posts").allowedOrigins("http://localhost:3000");
//            }
//        };
//
//    }
}
