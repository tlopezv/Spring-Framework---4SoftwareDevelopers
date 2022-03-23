package com.example.test;

import com.example.api.PersonaServiceAPI;
import com.example.config.AppConfig;
import com.example.impl.PersonaServiceImpl;
import com.example.model.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonaServiceAPI personaServiceAPI = context.getBean(PersonaServiceImpl.class);

        Persona persona = new Persona();
        persona.setNombre("Jordy");
        persona.setApellido("Apellido");

        personaServiceAPI.guardar(persona);
    }
}
