package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.SeccionMenu;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "seccion_menu_input")
@Getter
@Setter
public class SeccionMenuInputDto {
    private Long id;

    private SeccionMenu seccionMenu;

    private String inputType;

    private String inputLabel;

    private String inputId;

    private String inputName;

    private int inputCols;

    private int inputRequired;

    private String inputAccepts;

    private int alta;

    private int modifica;

    private int lista;

    private int filtro;

    private int encabezado;

    private int newLine;

    private int currencyFormat;

    private int orden;

    private String selectColumnas;

    private String urlGet;

    private String modelo;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;
}