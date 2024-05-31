package com.artplusplus.contpp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDto {
    @NotBlank
    private Long seccionMenuId;

    @NotBlank
    private Long grupoId;

    @NotBlank
    private String columna;
}
