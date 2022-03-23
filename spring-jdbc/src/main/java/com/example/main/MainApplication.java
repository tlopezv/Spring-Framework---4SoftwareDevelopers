package com.example.main;

import com.example.dao.api.PersonaDaoAPI;
import com.example.model.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/config/app-config.xml");

        PersonaDaoAPI personaDaoAPI = context.getBean(PersonaDaoAPI.class);

        Persona persona = new Persona();
        persona.setId(2L);
        persona.setNombre("Carlos");
        persona.setApellido("Salazar");
        persona.setDireccion("Cra 1000");
        persona.setTelefono("1212121212");

        personaDaoAPI.guardar(persona);

        System.out.println(personaDaoAPI.getPersonas());
    }
}
