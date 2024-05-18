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
@Table(name = "empleado")
@Data
@RequiredArgsConstructor
@Getter 
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Departamento departamento;

    @ManyToOne
    private Puesto puesto;

    @ManyToOne
    private PeriodicidadPago periodicidadPago;

    @ManyToOne
    private Escolaridad escolaridad;

    private String nombreCompleto;

    private String rfc;

    private String curp;

    private String nss;
    
    private String fechaNacimiento;

    private String telefono;

    private float salarioBase;

    private float salarioDiario;

    private float salarioDiarioIntegrado;

    private float salarioAsimilados;

    private String fechaInicioLaboral;

    private String fechaAltaImss;

    private int status;
}
