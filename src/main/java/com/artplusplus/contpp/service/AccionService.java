package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.AccionDto;
import com.artplusplus.contpp.model.Accion;

public interface AccionService {
    //Create operation
    Accion save(Accion accion);

    //Read operation
    List<Accion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    Accion getById(Long id);

    //Read operation filtered by specifications
    List<AccionDto> filteredList(Specification<Accion> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<Accion> specs);
}
