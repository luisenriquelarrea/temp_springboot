package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.AccionGrupo;

import com.artplusplus.contpp.repository.customMethods.AccionGrupoCustomMethods;

public interface AccionGrupoRepository extends JpaRepository<AccionGrupo, Long>, AccionGrupoCustomMethods, JpaSpecificationExecutor<AccionGrupo>{
    
}