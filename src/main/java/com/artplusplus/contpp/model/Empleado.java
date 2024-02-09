package com.artplusplus.contpp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer plazaId;

    private String nombreCompleto;

    private String rfc;

    private String curp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Integer plazaId) {
        this.plazaId = plazaId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
