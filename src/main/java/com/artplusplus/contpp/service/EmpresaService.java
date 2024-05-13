package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Empresa;

public interface EmpresaService {
    //Create operation
    Empresa save(Empresa empresa);

    //Read operation
    List<Empresa> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
