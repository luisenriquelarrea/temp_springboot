package com.artplusplus.contpp.service;

import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
public interface UsuarioService {
    //Create operation
    UsuarioDto save(Usuario usuario);

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    Optional<Usuario> getByName(String name);

    //Get entity by id
    UsuarioDto getById(Long id);

    Optional<Usuario> validUsernameAndPassword(String name, String password);
}