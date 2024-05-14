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
@Table(name = "descuento")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Descuento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Deduccion deduccion;

    @ManyToOne
    private TipoRecibo tipoRecibo;

    private float totalDescuento;

    private float totalPagado;

    private float saldo;

    private float montoDescuentoFijo;

    private float porcentajeDescuento;

    private int nPagosDescuento;

    private String fechaInicio;

    private String comentarios;

    private int status;
}