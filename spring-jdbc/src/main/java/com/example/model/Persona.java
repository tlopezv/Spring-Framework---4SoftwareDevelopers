package com.example.model;

import lombok.Data;

@Data
public class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
