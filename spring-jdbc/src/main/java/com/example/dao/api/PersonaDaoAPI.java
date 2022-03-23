package com.example.dao.api;

import com.example.model.Persona;

import java.util.List;

public interface PersonaDaoAPI {

    void guardar(Persona persona);

    List<Persona> getPersonas();

    void guardar(List<Persona> personas);
}
