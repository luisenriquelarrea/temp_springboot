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
@Table(name = "complemento_pago_documento")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class ComplementoPagoDocumento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ComplementoPago complementoPago;

    @ManyToOne
    private Factura factura;

    private float monto;

    private float saldoAnterior;

    private float saldoInsoluto;

    private int nParcialidad;

    private int status;
}