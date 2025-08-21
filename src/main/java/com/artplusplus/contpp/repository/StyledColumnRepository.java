package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.StyledColumn;

public interface StyledColumnRepository extends JpaRepository<StyledColumn, Long>, JpaSpecificationExecutor<StyledColumn> {

}
