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
@Table(name = "pago_descuento")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class PagoDescuento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Descuento descuento;

    private PeriodoPago periodoPago;

    private ReciboDeduccion reciboDeduccion;

    private float monto;

    private int status;
}