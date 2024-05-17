package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.UsoCfdi;

public interface UsoCfdiService {
    //Create operation
    UsoCfdi save(UsoCfdi usoCfdi);

    //Read operation
    List<UsoCfdi> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
