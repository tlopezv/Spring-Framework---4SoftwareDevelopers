package com.example.main;

import com.example.dao.api.PersonaDaoAPI;
import com.example.model.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/config/app-config.xml");

        PersonaDaoAPI personaDaoAPI = context.getBean(PersonaDaoAPI.class);

        /*Persona persona = new Persona();
        persona.setId(2L);
        persona.setNombre("Carlos");
        persona.setApellido("Salazar");
        persona.setDireccion("Cra 1000");
        persona.setTelefono("1212121212");*/

        // Realizamos la medición de tiempos a la implementación de guardado masivo de datos
        long start = System.currentTimeMillis();

        List<Persona> personas = new ArrayList<Persona>();

        for (long i = 3; i < 10000; i ++){
            Persona persona = new Persona();
            persona.setId(i);
            persona.setNombre("Nombre "+i);
            persona.setApellido("Apellido "+i);
            persona.setDireccion("Cra "+ i);
            persona.setTelefono("1212121212");

            personas.add(persona);
        }

        //for (Persona persona: personas){
            //personaDaoAPI.guardar(persona);
            // Duración en segundos: 1
            // Duración en milisegundos: 1514
        //}

        personaDaoAPI.guardar(personas);

        // Duración en segundos: 3
        //Duración en milisegundos: 3408
        
        long end = System.currentTimeMillis();

        System.out.println("Duración en segundos: "+ TimeUnit.MILLISECONDS.toSeconds(end-start));
        System.out.println("Duración en milisegundos: "+ (end-start));

        //System.out.println(personaDaoAPI.getPersonas());
    }
}
