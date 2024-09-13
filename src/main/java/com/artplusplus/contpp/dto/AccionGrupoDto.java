package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.model.SeccionMenu;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "accion_grupo")
@Getter
@Setter
public class AccionGrupoDto {
    private Long id;

    private Grupo grupo;

    private Accion accion;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;

    private SeccionMenu seccionMenu;
}