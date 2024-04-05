package com.artplusplus.contpp.service;

import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
public interface UsuarioService {

    //Get by id operation
    boolean getById(Long id);

    Optional<Usuario> getUserByUsername(String username);

    //Get Usuario entity by id
    UsuarioDto usuarioById(Long id);

    Optional<UsuarioDto> validUsernameAndPassword(String username, String password);
}