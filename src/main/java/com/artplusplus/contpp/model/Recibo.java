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
@Table(name = "recibo")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Recibo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Nomina nomina;

    private PeriodoPago periodoPago;

    private TipoRecibo tipoRecibo;

    private Sucursal sucursal;

    private Empresa empresa;

    private Empleado empleado;

    private String folio;

    private int nDiasPagados;

    private float salarioDiario;

    private float salarioDiarioIntegrado;

    private String uuid;

    private int status;
}