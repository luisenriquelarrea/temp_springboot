package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Departamento;

public interface DepartamentoService {
    //Create operation
    Departamento save(Departamento departamento);
    
    //Read operation
    List<Departamento> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}