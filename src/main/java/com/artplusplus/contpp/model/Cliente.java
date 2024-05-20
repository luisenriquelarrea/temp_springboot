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
@Table(name = "cliente")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RegimenFiscal regimenFiscal;

    private String razonSocial;

    private String rfc;

    private String telefono;

    private String correo;

    private String paginaWeb;

    private String codigoPostal;

    private int status;
}