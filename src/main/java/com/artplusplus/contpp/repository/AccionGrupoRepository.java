package com.artplusplus.contpp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoRepository extends CrudRepository<AccionGrupo, Long> {
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