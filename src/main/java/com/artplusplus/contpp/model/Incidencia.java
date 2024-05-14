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
@Table(name = "incidencia")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Incidencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoIncidencia incidencia;

    @ManyToOne
    private Empleado empleado;

    private String fecha;

    private String comentarios;

    private int status;
}