package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}