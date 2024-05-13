package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.AltaBajaImss;

public interface AltaBajaImssService {
    //Create operation
    AltaBajaImss save(AltaBajaImss altaBajaImss);

    //Read operation
    List<AltaBajaImss> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
