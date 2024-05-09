package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Empleado;

public interface EmpleadoService {
    //Cread operation
    Empleado save(Empleado empleado);

    //Read operation
    List<Empleado> list();

    //Delete operation
    void deleteById(Long id);

    //Get by id operation
    boolean getById(Long id);

    //Get Empleado entity by id
    Empleado empleadoById(Long id);
}