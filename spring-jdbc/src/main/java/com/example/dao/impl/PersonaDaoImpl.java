package com.example.dao.impl;

import com.example.dao.api.PersonaDaoAPI;
import com.example.dao.mapper.PersonaMapper;
import com.example.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

@Repository
public class PersonaDaoImpl implements PersonaDaoAPI {

    private JdbcTemplate jdbcTemplate;
    // Especificamente diseñado para las operaciones SQL que cuentan con parámetros nombrados
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Creamos el método de inicialización de las dos propiedades de arriba
    // Método que será inicializado por Spring Framework, de ahí que anotemos con @Autowired para que inyecte la dependencia
    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        init();
    }

    private void init(){
        StringBuilder sql = new StringBuilder(200);
        sql.append("CREATE TABLE IF NOT EXISTS persona (");
        sql.append(" id INT NOT NULL,");
        sql.append(" nombre VARCHAR(50) NOT NULL,");
        sql.append(" apellido VARCHAR(50) NOT NULL,");
        sql.append(" direccion VARCHAR(50),");
        sql.append(" telefono VARCHAR(50))");

        jdbcTemplate.execute(sql.toString());
    }

    @Override
    public void guardar(Persona persona) {
        StringBuilder sql = new StringBuilder(100);
        sql.append("INSERT INTO persona");
        sql.append(" VALUES (:id,:nombre,:apellido,:direccion,:telefono)");

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", persona.getId(), Types.INTEGER);
        params.addValue("nombre", persona.getNombre(), Types.VARCHAR);
        params.addValue("apellido", persona.getApellido(), Types.VARCHAR);
        params.addValue("direccion", persona.getDireccion(), Types.VARCHAR);
        params.addValue("telefono", persona.getTelefono(), Types.VARCHAR);

        namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    @Override
    public List<Persona> getPersonas() {
        StringBuilder sql = new StringBuilder(100);
        sql.append("SELECT * FROM persona");

        return jdbcTemplate.query(sql.toString(), new PersonaMapper());
    }
}
