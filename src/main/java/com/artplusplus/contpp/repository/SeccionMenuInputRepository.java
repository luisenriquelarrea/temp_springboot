package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputRepository extends JpaRepository<SeccionMenuInput, Long>, JpaSpecificationExecutor<SeccionMenuInput> {

}
