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
@Table(name = "recibo_percepcion")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class ReciboPercepcion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recibo recibo;

    @ManyToOne
    private Percepcion percepcion;

    private float montoGravado;

    private float montoExento;

    private int status;
}