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
@Table(name = "concepto")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Concepto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Unidad unidad;

    @ManyToOne
    private Producto producto;

    private String descripcion;

    private String noIdentificacion;

    private float factorIvaRetenido;

    private float factorIvaTrasladado;

    private float factorIsrRetenido;

    private float factorIsrTrasladado;

    private float factorIepsTrasladado;

    private int status;
}