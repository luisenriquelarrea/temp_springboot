package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ExpedienteEmpleado;

public interface ExpedienteEmpleadoService {
    //Create operation
    ExpedienteEmpleado save(ExpedienteEmpleado expedienteEmpleado);

    //Read operation
    List<ExpedienteEmpleado> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
