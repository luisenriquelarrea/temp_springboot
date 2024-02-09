package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Empleado;

public interface EmpleadoService {
    //Cread operation
    Empleado saveEmpleado(Empleado empleado);

    //Read operation
    List<Empleado> listEmpleado();

    //Update operation
    Empleado updateEmpleado(Empleado empleado, Long empleadoId);

    //Delete operation
    void deleteEmpleado(Long empleadoId);

    //Get by id operation
    boolean getById(Long empleadoId);
}