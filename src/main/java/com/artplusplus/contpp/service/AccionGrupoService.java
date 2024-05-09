package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoService {

    //Read operation
    List<AccionGrupo> list();

    List<SeccionMenu> getAllowedMenus(Long grupoId);

    List<Accion> getAllowedBreadcrumbs(Long grupoId, Long seccionMenuId);

    List<Accion> getAllowedTableActions(Long grupoId, Long seccionMenuId);

    List<Accion> getAllowedExportData(Long grupoId, Long seccionMenuId);
}