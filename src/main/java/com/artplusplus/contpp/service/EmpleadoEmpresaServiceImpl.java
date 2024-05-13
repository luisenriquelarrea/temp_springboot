package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.EmpleadoEmpresa;
import com.artplusplus.contpp.repository.EmpleadoEmpresaRepository;

import java.util.List;

@Service
public class EmpleadoEmpresaServiceImpl implements EmpleadoEmpresaService {
    @Autowired
    private EmpleadoEmpresaRepository empleadoEmpresaRepository;

    @Override
    public EmpleadoEmpresa save(EmpleadoEmpresa empleadoEmpresa) {
        return empleadoEmpresaRepository.save(empleadoEmpresa);
    }

    @Override
    public List<EmpleadoEmpresa> list(){
        return (List<EmpleadoEmpresa>) empleadoEmpresaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        empleadoEmpresaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return empleadoEmpresaRepository.existsById(id);
    }
}
