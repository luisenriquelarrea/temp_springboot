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
@Table(name = "serie_cfdi")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class SerieCfdi {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private TipoOperacion tipoOperacion;

    private Plaza plaza;

    private Empresa empresa;

    private String descripcion;

    private int folioInicialFactura;

    private int folioInicialComplemento;

    private int folioInicialNotaCredito;

    private int status;
}