package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.SeccionMenuInputDto;
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

    //Get entity by id
    SeccionMenuInput getById(Long id);

    //Read operation filtered by specifications
    List<SeccionMenuInputDto> filteredList(Specification<SeccionMenuInput> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<SeccionMenuInput> specs);

    SeccionMenuInput saveOrUpdate(SeccionMenuInput input);
}
