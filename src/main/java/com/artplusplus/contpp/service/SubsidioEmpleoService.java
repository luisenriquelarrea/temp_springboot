package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SubsidioEmpleo;

public interface SubsidioEmpleoService {
    //Create operation
    SubsidioEmpleo save(SubsidioEmpleo subsidioEmpleo);

    //Read operation
    List<SubsidioEmpleo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
