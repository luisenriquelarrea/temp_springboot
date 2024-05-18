package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SerieCfdi;

public interface SerieCfdiService {
    //Create operation
    SerieCfdi save(SerieCfdi serieCfdi);

    //Read operation
    List<SerieCfdi> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
