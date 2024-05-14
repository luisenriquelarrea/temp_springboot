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
@Table(name = "recibo")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Recibo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Nomina nomina;

    @ManyToOne
    private PeriodoPago periodoPago;

    @ManyToOne
    private TipoRecibo tipoRecibo;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Empleado empleado;

    private String folio;

    private int nDiasPagados;

    private float salarioDiario;

    private float salarioDiarioIntegrado;

    private String uuid;

    private int status;
}