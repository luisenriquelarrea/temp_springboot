package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Accion;

public interface AccionRepository extends CrudRepository<Accion, Long> {
    
}