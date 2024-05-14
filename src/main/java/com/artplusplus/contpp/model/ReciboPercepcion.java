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
@Table(name = "recibo_percepcion")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class ReciboPercepcion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Recibo recibo;

    private Percepcion percepcion;

    private float montoGravado;

    private float montoExento;

    private int status;
}