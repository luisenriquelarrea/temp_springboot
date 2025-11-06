package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.SeccionMenu;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "styled_column")
@Getter
@Setter
public class StyledColumnDto {
    private Long id;

    private SeccionMenu seccionMenu;

    private String columna;

    private String valor;

    private String backgroundColor;

    private String color;

    private String border;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;
}