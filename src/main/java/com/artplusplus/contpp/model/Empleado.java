package com.artplusplus.contpp.model;

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

    public Integer getPlazaId() {
        return plaza_id;
    }

    public void setPlazaId(Integer plaza_id) {
        this.plaza_id = plaza_id;
    }

    public String getNombreCompleto() {
        return nombre_completo;
    }

    public void setNombreCompleto(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getRFC(){
        return rfc;
    }

    public void setRFC(String rfc) {
        this.rfc = rfc;
    }

    public String getCURP(){
        return curp;
    }

    public void setCURP(String curp) {
        this.curp = curp;
    }
}
