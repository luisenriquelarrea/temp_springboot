package com.artplusplus.contpp.repository.customMethods;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoCustomMethods {
    @Query("SELECT ag.accion "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.accion.seccionMenu.id = :seccionMenuId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onNavbar = 1 ")
    List<Accion> getAllowedBreadcrumbs(@Param("grupoId") Long grupoId, 
        @Param("seccionMenuId") Long seccionMenuId);

    @Query("SELECT ag.accion.seccionMenu "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onNavbar = 1 "+
        "AND ag.accion.seccionMenu.status = 1 "+
        "AND ag.accion.seccionMenu.menu.status = 1 ")
    List<SeccionMenu> getAllowedMenus(@Param("grupoId") Long grupoId);

    @Query("SELECT ag.accion "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.accion.seccionMenu.id = :seccionMenuId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onTable = 1 ")
    List<Accion> getAllowedTableActions(@Param("grupoId") Long grupoId, 
        @Param("seccionMenuId") Long seccionMenuId);

        @Query("SELECT ag.accion "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.accion.seccionMenu.id = :seccionMenuId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.descripcion = 'xls' ")
    List<Accion> getAllowedExportData(@Param("grupoId") Long grupoId, 
        @Param("seccionMenuId") Long seccionMenuId);
}
