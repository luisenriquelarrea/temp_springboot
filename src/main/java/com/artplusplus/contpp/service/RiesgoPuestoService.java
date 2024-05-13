package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.RiesgoPuesto;

public interface RiesgoPuestoService {
    //Create operation
    RiesgoPuesto save(RiesgoPuesto riesgoPuesto);

    //Read operation
    List<RiesgoPuesto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
