package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByName(String username);
}