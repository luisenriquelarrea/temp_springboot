package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Empleado;
import com.artplusplus.contpp.repository.EmpleadoRepository;
import com.artplusplus.contpp.repository.specifications.EmpleadoSpecifications;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> list(){
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        empleadoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return empleadoRepository.existsById(id);
    }

    @Override
    public Empleado getById(Long id){
        return empleadoRepository.findById(id).get();
    }

    @Override
    public List<Empleado> filteredList(String rfc){
        return (List<Empleado>) empleadoRepository.findAll(EmpleadoSpecifications.rfc(rfc));
    }
}
