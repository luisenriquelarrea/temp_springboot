package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.Accion;

public interface AccionRepository extends JpaRepository<Accion, Long>, JpaSpecificationExecutor<Accion> {

}
