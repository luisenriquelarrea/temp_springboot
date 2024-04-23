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
@Table(name = "seccion_menu_input")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class SeccionMenuInput {
    @ManyToOne
    private SeccionMenu seccionMenu;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String inputType;

    private String inputLabel;

    private String inputId;

    private String inputName;

    private int inputCols;

    private int inputRequired;

    private int alta;

    private int modifica;

    private int lista;

    private int filtro;

    private int orden;

    private String modelo;

    private int status;
}
