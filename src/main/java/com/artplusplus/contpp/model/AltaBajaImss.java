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
@Table(name = "altas_bajas_imss")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class AltaBajaImss {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Empleado empleado;

    private Sucursal sucursal;

    private Empresa empresa;

    private float salarioDiario;

    private float salarioDiarioIntegrado;

    private String fecha;

    private String movimiento;

    private int status;
}