package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.EmpleadoCuentaBancaria;
import com.artplusplus.contpp.repository.EmpleadoCuentaBancariaRepository;

import java.util.List;

@Service
public class EmpleadoCuentaBancariaServiceImpl implements EmpleadoCuentaBancariaService {
    @Autowired
    private EmpleadoCuentaBancariaRepository empleadoCuentaBancariaRepository;

    @Override
    public EmpleadoCuentaBancaria save(EmpleadoCuentaBancaria empleadoCuentaBancaria) {
        return empleadoCuentaBancariaRepository.save(empleadoCuentaBancaria);
    }

    @Override
    public List<EmpleadoCuentaBancaria> list(){
        return (List<EmpleadoCuentaBancaria>) empleadoCuentaBancariaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        empleadoCuentaBancariaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return empleadoCuentaBancariaRepository.existsById(id);
    }
}
