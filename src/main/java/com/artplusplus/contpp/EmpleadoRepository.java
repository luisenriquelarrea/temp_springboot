package com.artplusplus.contpp;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.Empleado;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

}