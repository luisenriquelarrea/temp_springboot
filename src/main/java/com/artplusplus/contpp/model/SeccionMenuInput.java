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
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SeccionMenu seccionMenu;

    private String inputType;

    private String inputLabel;

    private String inputId;

    private String inputName;

    private int inputCols;

    private int inputRequired;

    private String inputAccepts;

    private String keyboardType;

    private int alta;

    private int modifica;

    private int lista;

    private int filtro;

    private int encabezado;

    private int newLine;

    private int multiple;

    private int currencyFormat;

    private int orden;

    private String selectColumnas;

    private String selectValues;

    private String selectFilters;

    private String urlGet;

    private String modelo;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;
}