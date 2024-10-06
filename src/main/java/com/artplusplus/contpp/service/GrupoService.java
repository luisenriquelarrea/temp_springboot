package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.GrupoDto;
import com.artplusplus.contpp.model.Grupo;

public interface GrupoService {
    //Create operation
    Grupo save(Grupo grupo);

    //Read operation
    List<Grupo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    Grupo getById(Long id);

    //Read operation filtered by specifications
    List<GrupoDto> filteredList(Specification<Grupo> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<Grupo> specs);
}
