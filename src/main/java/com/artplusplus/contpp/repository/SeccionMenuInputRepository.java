package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

import com.artplusplus.contpp.repository.customMethods.SeccionMenuInputCustomMethods;

import java.util.List;

public interface SeccionMenuInputRepository extends CrudRepository<SeccionMenuInput, Long>,  SeccionMenuInputCustomMethods{
    List<SeccionMenuInput> findBySeccionMenuId(Long seccionMenuId);

    List<SeccionMenuInput> findBySeccionMenuIdAndAltaAndStatus(Long seccionMenuId, int alta, int status);

    List<SeccionMenuInput> findBySeccionMenuIdAndModificaAndStatus(Long seccionMenuId, int modifica, int status);

    List<SeccionMenuInput> findBySeccionMenuIdAndListaAndStatus(Long seccionMenuId, int lista, int status);

    List<SeccionMenuInput> findBySeccionMenuIdAndFiltroAndStatus(Long seccionMenuId, int filtro, int status);
}