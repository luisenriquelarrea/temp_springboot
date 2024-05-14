package com.artplusplus.contpp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prenomina_detalle")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class PrenominaDetalle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Prenomina prenomina;

    @ManyToOne
    private Empleado empleado;

    private int nDiasSueldos;

    private int nDiasContable;

    private float sueldoBase;

    private float bonosContable;

    private float otrosDescuentosContable;

    private float suedosSalarios;

    private float bonosSueldos;

    private float subsidioEmpleoCausado;

    private float subsidioEmpleoEntregar;

    private float isrDeterminado;

    private float isrPagar;

    private float imss;

    private float infonavit;

    private float otrosDescuentosSueldos;

    private float netoAsimilados;

    private float netoSueldosSalarios;

    private float netoContable;

    private int status;
}