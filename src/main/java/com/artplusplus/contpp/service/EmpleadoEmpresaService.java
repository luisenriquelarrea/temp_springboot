package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.EmpleadoEmpresa;

public interface EmpleadoEmpresaService {
    //Create operation
    EmpleadoEmpresa save(EmpleadoEmpresa empleadoEmpresa);

    //Read operation
    List<EmpleadoEmpresa> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
