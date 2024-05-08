package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.AccionGrupo;

import com.artplusplus.contpp.repository.customMethods.AccionGrupoCustomMethods;

public interface AccionGrupoRepository extends CrudRepository<AccionGrupo, Long>, AccionGrupoCustomMethods{
    
}