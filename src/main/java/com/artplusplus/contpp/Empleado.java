package com.artplusplus.contpp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer plaza_id;

    private String nombre_completo;

    private String rfc;

    private String curp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nombre_completo;
    }

    public void setName(String name) {
        this.nombre_completo = name;
    }
}
