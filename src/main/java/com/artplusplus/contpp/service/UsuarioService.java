package com.artplusplus.contpp.service;

import com.artplusplus.contpp.dto.UsuarioDto;

import java.util.Optional;
public interface UsuarioService {

    //Get by id operation
    boolean getById(Long id);

    Optional<UsuarioDto> getUserByUsername(String username);

    //Get Usuario entity by id
    UsuarioDto usuarioById(Long id);

    Optional<UsuarioDto> validUsernameAndPassword(String username, String password);
}