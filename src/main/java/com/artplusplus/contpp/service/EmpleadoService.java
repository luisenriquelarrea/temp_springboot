package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Empleado;

public interface EmpleadoService {
    //Cread operation
    Empleado saveEmpleado(Empleado empleado);

    //Read operation
    List<Empleado> listEmpleado();

    //Update operation
    //Empleado updateEmpleado(Empleado empleado, Long id);

    //Delete operation
    void deleteEmpleado(Long id);

    //Get by id operation
    boolean getById(Long id);

    //Get Empleado entity by id
    Empleado empleadoById(Long id);
}