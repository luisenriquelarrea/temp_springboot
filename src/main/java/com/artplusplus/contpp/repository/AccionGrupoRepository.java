package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;

import java.util.List;

public interface AccionGrupoRepository extends JpaRepository<AccionGrupo, Long>, JpaSpecificationExecutor<AccionGrupo>{
    @Query("SELECT ag.accion "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.accion.seccionMenu.id = :seccionMenuId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onBreadcrumb = 1 ")
    List<Accion> getAllowedBreadcrumbs(@Param("grupoId") Long grupoId, 
        @Param("seccionMenuId") Long seccionMenuId);

        @Query("SELECT ag.accion "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.accion.seccionMenu.id = :seccionMenuId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onNavbar = 1 ")
    List<Accion> getAllowedNavbar(@Param("grupoId") Long grupoId, 
        @Param("seccionMenuId") Long seccionMenuId);

    @Query("SELECT ag.accion.seccionMenu "+
        "FROM AccionGrupo ag "+
        "WHERE ag.grupo.id = :grupoId "+
        "AND ag.status = 1 "+
        "AND ag.grupo.status = 1 "+
        "AND ag.accion.status = 1 "+
        "AND ag.accion.onBreadcrumb = 1 "+
        "AND ag.accion.seccionMenu.status = 1 "+
        "AND ag.accion.seccionMenu.menu.status = 1 "+
        "ORDER BY ag.accion.seccionMenu.menu.descripcion ASC, "+ 
        "ag.accion.seccionMenu.descripcion ASC ")
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
}