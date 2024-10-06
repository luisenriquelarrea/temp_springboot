package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.SeccionMenu;

public interface SeccionMenuRepository extends JpaRepository<SeccionMenu, Long>, JpaSpecificationExecutor<SeccionMenu> {

}
