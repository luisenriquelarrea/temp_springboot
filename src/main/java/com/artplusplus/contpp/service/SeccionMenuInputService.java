package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputService {
    //Create operation
    SeccionMenuInput save(SeccionMenuInput seccionMenuInput);
    
    //Read operation
    List<SeccionMenuInput> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    List<SeccionMenuInput> getBySeccionMenu(Long seccionMenuId);

    List<SeccionMenuInput> getInputsAlta(Long seccionMenuId);

    List<SeccionMenuInput> getInputsModifica(Long seccionMenuId);

    List<SeccionMenuInput> getInputsLista(Long seccionMenuId);

    List<SeccionMenuInput> getInputsFiltro(Long seccionMenuId);
}