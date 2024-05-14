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
@Table(name = "bono")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Bono {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Percepcion percepcion;

    @ManyToOne
    private PeriodoPago periodoPago;

    @ManyToOne
    private TipoRecibo tipoRecibo;

    private float monto;

    private float saldo;

    private String comentarios;

    private int tiempoIndeterminado;

    private int status;
}