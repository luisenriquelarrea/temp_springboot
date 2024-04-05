package com.artplusplus.contpp.service;

import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
public interface UsuarioService {

    //Get by id operation
    boolean getById(Long id);

    Optional<Usuario> getUserByName(String name);

    //Get Usuario entity by id
    UsuarioDto usuarioById(Long id);

    Optional<Usuario> validUsernameAndPassword(String name, String password);
}