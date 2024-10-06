package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.AccionGrupoDto;
import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;

public interface AccionGrupoService {
    //Create operation
    AccionGrupo save(AccionGrupo accionGrupo);

    //Read operation
    List<AccionGrupo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    AccionGrupo getById(Long id);

    //Read operation filtered by specifications
    List<AccionGrupoDto> filteredList(Specification<AccionGrupo> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<AccionGrupo> specs);

    List<SeccionMenu> getAllowedMenus(Long grupoId);

    List<Accion> getAllowedBreadcrumbs(Long grupoId, Long seccionMenuId);

    List<Accion> getAllowedNavbar(Long grupoId, Long seccionMenuId);

    List<Accion> getAllowedTableActions(Long grupoId, Long seccionMenuId);
}