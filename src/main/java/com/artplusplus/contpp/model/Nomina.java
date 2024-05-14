package com.artplusplus.contpp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nomina")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Nomina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Plaza plaza;

    private PeriodoPago periodoPago;

    private String folio;

    private String descripcion;

    private String fecha;

    private int esAguinaldo;

    private int esFiniquito;

    private int esPtu;

    private int nominaOk;

    private int pagoOk;

    private int timbradoOk;
    
    private int status;
}