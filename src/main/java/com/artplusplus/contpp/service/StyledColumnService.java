package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.StyledColumnDto;
import com.artplusplus.contpp.model.StyledColumn;

public interface StyledColumnService {
    //Create operation
    StyledColumn save(StyledColumn styledColumn);

    //Read operation
    List<StyledColumn> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    StyledColumn getById(Long id);

    //Read operation filtered by specifications
    List<StyledColumnDto> filteredList(Specification<StyledColumn> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<StyledColumn> specs);
}
