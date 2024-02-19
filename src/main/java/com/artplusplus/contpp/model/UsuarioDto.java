package com.artplusplus.contpp.model;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Getter 
@Setter
public class UsuarioDto {
    private Long id;

    private String name;

    private String email;
}
