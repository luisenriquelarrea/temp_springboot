package com.artplusplus.contpp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeccionMenuInputDto {
    private Long id;

    private SeccionMenuDto seccionMenu;

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

    private int vista;

    private int filtro;

    private int encabezado;

    private int newLine;

    private int multiple;

    private int currencyFormat;

    private int numberFormat;

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

    private int offset;

    private int limit;
}