package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoService {

    //Read operation
    List<AccionGrupo> list();

    List<SeccionMenu> getAllowedMenus(Long grupoId);
}