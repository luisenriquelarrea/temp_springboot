package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.Menu;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "seccion_menu")
@Getter
@Setter
public class SeccionMenuDto {
    private Long id;

    private Menu menu;

    private String descripcion;

    private String navbarLabel;

    private String icon;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;
}