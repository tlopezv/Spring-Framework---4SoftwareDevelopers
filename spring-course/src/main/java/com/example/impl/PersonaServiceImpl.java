package com.example.impl;

import com.example.api.PersonaServiceAPI;
import com.example.model.Persona;

public class PersonaServiceImpl implements PersonaServiceAPI {

    private String fuente;

    public PersonaServiceImpl(String fuente){
        super();
        this.fuente=fuente;
        System.out.println("Fuente de instancia: " + fuente);
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    @Override
    public void guardar(Persona persona) {
        if (persona == null){
            throw new IllegalArgumentException("El argumento persona es nulo");
        }

        System.out.println("Persona guardado con exito");
        System.out.println(persona.toString());
    }
}
