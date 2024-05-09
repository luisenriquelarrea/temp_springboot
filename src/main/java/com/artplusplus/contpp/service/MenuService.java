package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Menu;

public interface MenuService {
    //Create operation
    Menu save(Menu menu);
    
    //Read operation
    List<Menu> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}