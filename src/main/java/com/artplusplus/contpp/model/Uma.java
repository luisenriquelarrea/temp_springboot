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
@Table(name = "uma")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Uma {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private float monto;

    private String fechaInicio;

    private String fechaFinal;

    private int status;
}