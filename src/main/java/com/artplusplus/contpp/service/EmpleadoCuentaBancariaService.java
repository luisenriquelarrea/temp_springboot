package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.EmpleadoCuentaBancaria;

public interface EmpleadoCuentaBancariaService {
    //Create operation
    EmpleadoCuentaBancaria save(EmpleadoCuentaBancaria empleadoCuentaBancaria);

    //Read operation
    List<EmpleadoCuentaBancaria> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
