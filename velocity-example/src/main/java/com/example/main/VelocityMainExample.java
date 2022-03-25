package com.example.main;

import com.example.model.Persona;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class VelocityMainExample {

    public static void main(String[] args) {

        // 1. Inicialización del motor de Velocity
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        engine.init();

        // 2. Creación y llenado de la lista de personas
        List<Persona> personas = new ArrayList<Persona>();
        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona();
            persona.setNombre("Persona "+i);
            persona.setEdad(18 + i);
            personas.add(persona);
        }

        // 3. Inicializar el contexto de Velocity
        VelocityContext context = new VelocityContext();
        context.put("title", "Página de prueba");
        context.put("personas", personas);

        // 4. Recuperar plantilla de ruta específica
        //Template template = engine.getTemplate("\\templates\\prueba.vm");
        Template template = engine.getTemplate("/templates/prueba.vm");

        // 5. Obtención de resultado
        StringWriter stringWriter = new StringWriter();
        template.merge(context, stringWriter);

        System.out.println(stringWriter.toString());

        try {
            FileWriter fileWriter = new FileWriter(new File("src/main/resources/outputs/prueba.html"));
            template.merge(context, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
