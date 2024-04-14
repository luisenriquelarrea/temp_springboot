package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.SeccionMenu;

import java.util.List;

public interface SeccionMenuRepository extends CrudRepository<SeccionMenu, Long> {
    List<SeccionMenu> findByStatus(int status);
}