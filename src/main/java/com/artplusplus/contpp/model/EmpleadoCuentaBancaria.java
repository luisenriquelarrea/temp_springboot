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
@Table(name = "empleado_cuenta_bancaria")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class EmpleadoCuentaBancaria {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private TipoRecibo tipoRecibo;

    @ManyToOne
    private Banco banco;

    private String cuenta;

    private String numeroTarjeta;

    private String clabeInterbancaria;

    private int esCheque;

    private int status;
}