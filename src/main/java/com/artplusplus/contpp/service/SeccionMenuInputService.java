package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputService {

    //Read operation
    List<SeccionMenuInput> list();

    List<SeccionMenuInput> listBySeccionMenu(Long seccionMenuId);
}