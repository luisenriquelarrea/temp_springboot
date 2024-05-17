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
@Table(name = "nota_credito_documento")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class NotaCreditoDocumento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private NotaCredito notaCredito;

    private Factura factura;

    private int status;
}