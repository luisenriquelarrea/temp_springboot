package com.artplusplus.contpp.service;

import java.util.List;
import java.util.Optional;

import com.artplusplus.contpp.model.SeccionMenu;

public interface SeccionMenuService {
    //Create operation
    SeccionMenu save(SeccionMenu seccionMenu);
    
    //Read operation
    List<SeccionMenu> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    SeccionMenu getById(Long id);

    //Get SeccionMenu entity by descripcion
    Optional<SeccionMenu> getByDescripcion(String descripcion);
}