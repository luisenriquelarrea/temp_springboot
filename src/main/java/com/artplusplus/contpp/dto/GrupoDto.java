package com.artplusplus.contpp.dto;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "grupo")
@Getter
@Setter
public class GrupoDto {
    private Long id;

    private String descripcion;

    private int status;

    public String createdAt;

    public String updatedAt;

    public Integer userCreatedId;

    public Integer userUpdatedId;

    private int offset;

    private int limit;
}