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
@Table(name = "factura_concepto")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class FacturaConcepto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Factura factura;

    @ManyToOne
    private Concepto concepto;

    private String descripcion;

    private float cantidad;

    private float precioUnitario;

    private float importe;

    private float descuento;

    private float ivaTrasladado;

    private float ivaRetenido;

    private float isrRetenido;

    private float iepsTrasladado;

    private int status;
}