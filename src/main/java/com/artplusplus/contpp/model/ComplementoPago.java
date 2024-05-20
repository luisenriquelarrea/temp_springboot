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
@Table(name = "complemento_pago")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class ComplementoPago {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Plaza plaza;

    @ManyToOne
    private MetodoPago metodoPago;

    @ManyToOne
    private FormaPago formaPago;

    @ManyToOne
    private TipoCambio tipoCambio;

    @ManyToOne
    private TipoComprobante tipoComprobante;

    @ManyToOne
    private UsoCfdi usoCfdi;

    @ManyToOne
    private TipoOperacion tipoOperacion;

    @ManyToOne
    private Cliente cliente;

    private String serie;

    private String folio;

    private String fecha;

    private String hora;

    private float saldo;

    private float subtotal;

    private float total;

    private String uuid;

    private String observaciones;

    private int status;
}