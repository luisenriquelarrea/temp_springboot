package com.artplusplus.contpp.repository.customMethods;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoCustomMethods {
    @Query("SELECT ag.accion.seccionMenu "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onNavbar = 1 "+
        "AND ag.accion.seccionMenu.status = 1 "+
        "AND ag.accion.seccionMenu.menu.status = 1 ")
    List<SeccionMenu> getAllowedMenus(@Param("grupoId") Long grupoId);
}
