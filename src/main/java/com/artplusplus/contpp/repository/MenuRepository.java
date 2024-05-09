package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    
}