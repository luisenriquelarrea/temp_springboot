package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Usuario;

public interface UsuarioService {

    //Read operation
    List<Usuario> listUsuario();

    //Get by id operation
    boolean getById(Long id);

    //Get Usuario entity by id
    Usuario usuarioById(Long id);
}