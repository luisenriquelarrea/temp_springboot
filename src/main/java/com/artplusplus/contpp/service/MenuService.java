package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.MenuDto;
import com.artplusplus.contpp.model.Menu;

public interface MenuService {
    //Create operation
    Menu save(Menu menu);

    //Read operation
    List<Menu> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    Menu getById(Long id);

    //Read operation filtered by specifications
    List<MenuDto> filteredList(Specification<Menu> specs, PageRequest pageRequest);

    //Count entity records
    long count();

    //Count entity records with filter
    long countFilteredList(Specification<Menu> specs);
}
