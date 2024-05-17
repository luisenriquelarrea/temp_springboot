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
@Table(name = "nota_credito")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class NotaCredito {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Empresa empresa;

    private Plaza plaza;

    private MetodoPago metodoPago;

    private FormaPago formaPago;

    private TipoCambio tipoCambio;

    private TipoComprobante tipoComprobante;

    private UsoCfdi usoCfdi;

    private TipoOperacion tipoOperacion;

    private Cliente cliente;

    private Concepto concepto;

    private String descripcion;

    private float cantidad;

    private float precioUnitario;

    private float importe;

    private float total;

    private float ivaTrasladado;

    private String serie;

    private String folio;

    private String fecha;

    private String hora;

    private String uuid;

    private String observaciones;

    private int status;
}