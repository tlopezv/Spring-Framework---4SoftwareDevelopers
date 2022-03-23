package com.example.config;

import com.example.impl.PersonaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonaServiceImpl personaServiceImpl(){
        return new PersonaServiceImpl("JAVA");
    }
}
