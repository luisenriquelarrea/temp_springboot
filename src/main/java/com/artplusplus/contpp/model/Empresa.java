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
@Table(name = "empresa")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private RegimenFiscal regimenFiscal;

    private String razonSocial;

    private String rfc;

    private String curp;

    private int esPersonaFisica;

    private int status;
}