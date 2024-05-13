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
@Table(name = "bono")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Bono {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Empleado empleado;

    private Percepcion percepcion;

    private PeriodoPago periodoPago;

    private TipoRecibo tipoRecibo;

    private float monto;

    private float saldo;

    private String comentarios;

    private int tiempoIndeterminado;

    private int status;
}