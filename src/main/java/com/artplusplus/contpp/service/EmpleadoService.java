package com.artplusplus.contpp.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Empleado;

public interface EmpleadoService {
    //Cread operation
    Empleado save(Empleado empleado);

    //Read operation
    List<Empleado> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    Empleado getById(Long id);

    List<Empleado> filteredList(Specification<Empleado> specs);
}