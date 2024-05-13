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
@Table(name = "periodo_pago")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class PeriodoPago {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private PeriodicidadPago periodicidadPago;

    private Ejercicio ejercicio;

    private Mes mes;

    private String descripcion;

    private String fecha_inicio;

    private String fecha_final;

    private String fecha_pago;

    private int status;
}