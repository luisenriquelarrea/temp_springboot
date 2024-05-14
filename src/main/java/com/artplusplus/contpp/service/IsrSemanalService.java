package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.IsrSemanal;

public interface IsrSemanalService {
    //Create operation
    IsrSemanal save(IsrSemanal isrSemanal);

    //Read operation
    List<IsrSemanal> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
