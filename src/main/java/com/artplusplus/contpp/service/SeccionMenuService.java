package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SeccionMenu;

public interface SeccionMenuService {

    //Read operation
    List<SeccionMenu> listSeccionMenu();

    //Get by id operation
    boolean getById(Long id);

    //Get SeccionMenu entity by id
    SeccionMenu seccionMenuById(Long id);
}