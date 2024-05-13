package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Uma;

public interface UmaService {
    //Create operation
    Uma save(Uma uma);

    //Read operation
    List<Uma> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
