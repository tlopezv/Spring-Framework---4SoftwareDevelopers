package com.example.test;

import com.example.api.PersonaServiceAPI;
import com.example.impl.PersonaServiceImpl;
import com.example.model.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/config/app-config.xml");
        PersonaServiceAPI personaServiceAPI = context.getBean(PersonaServiceImpl.class);

        Persona persona = new Persona();
        persona.setNombre("Jordy");
        persona.setApellido("Apellido");

        personaServiceAPI.guardar(persona);
    }
}
