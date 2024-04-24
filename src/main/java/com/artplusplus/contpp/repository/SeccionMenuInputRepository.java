package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

import java.util.List;

public interface SeccionMenuInputRepository extends CrudRepository<SeccionMenuInput, Long> {
    List<SeccionMenuInput> findBySeccionMenu(Long seccionMenuId);
}