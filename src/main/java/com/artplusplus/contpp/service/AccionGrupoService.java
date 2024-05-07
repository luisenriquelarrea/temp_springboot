package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.AccionGrupo;

public interface AccionGrupoService {

    //Read operation
    List<AccionGrupo> list();

    List<AccionGrupo> listByGrupo(Long grupoId);
}