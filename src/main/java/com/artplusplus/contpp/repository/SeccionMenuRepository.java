package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.SeccionMenu;

import java.util.List;
import java.util.Optional;

public interface SeccionMenuRepository extends CrudRepository<SeccionMenu, Long> {
    List<SeccionMenu> findByStatus(int status);
    Optional<SeccionMenu> findByDescripcion(String username);
}