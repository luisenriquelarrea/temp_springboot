package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    Optional<Usuario> findByUsernameAndStatus(String username, int status);
}