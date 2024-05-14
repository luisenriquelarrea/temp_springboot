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
@Table(name = "tipo_recibo")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class TipoRecibo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoRegimen tipoRegimen;

    @ManyToOne
    private TipoNomina tipoNomina;

    @ManyToOne
    private TipoContrato tipoContrato;

    @ManyToOne
    private TipoJornada tipoJornada;

    @ManyToOne
    private RiesgoPuesto riesgoPuesto;

    private String codigo;

    private String descripcion;

    private int esCfdi;

    private int status;
}