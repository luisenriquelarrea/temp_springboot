package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.SeccionMenu;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "accion")
@Getter
@Setter
public class AccionDto {
    private Long id;

    private SeccionMenu seccionMenu;

    private String descripcion;

    private String label;

    private String icon;

    private String callMethod;

    private int onBreadcrumb;

    private int onNavbar;

    private int onTable;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;
}