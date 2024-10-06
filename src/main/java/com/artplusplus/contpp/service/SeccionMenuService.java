package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.SeccionMenuDto;
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

    //Read operation filtered by specifications
    List<SeccionMenuDto> filteredList(Specification<SeccionMenu> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<SeccionMenu> specs);
}
