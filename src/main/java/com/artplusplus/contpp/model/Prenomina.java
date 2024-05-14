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
@Table(name = "prenomina")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Prenomina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Plaza plaza;

    private PeriodoPago periodoPago;

    private String descripcion;

    private int prenominaOk;

    private int status;
}