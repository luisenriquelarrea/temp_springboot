package com.artplusplus.contpp.service;

import com.artplusplus.contpp.model.UsuarioDto;

public interface UsuarioService {

    //Get by id operation
    boolean getById(Long id);

    //Get Usuario entity by id
    UsuarioDto usuarioById(Long id);
}