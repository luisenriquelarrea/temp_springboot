package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

import com.artplusplus.contpp.repository.customMethods.SeccionMenuInputCustomMethods;

import java.util.List;

public interface SeccionMenuInputRepository extends CrudRepository<SeccionMenuInput, Long>,  SeccionMenuInputCustomMethods{
    List<SeccionMenuInput> findBySeccionMenuId(Long seccionMenuId);
}