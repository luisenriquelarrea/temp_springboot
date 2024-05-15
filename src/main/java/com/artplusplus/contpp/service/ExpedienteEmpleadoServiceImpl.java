package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ExpedienteEmpleado;
import com.artplusplus.contpp.repository.ExpedienteEmpleadoRepository;

import java.util.List;

@Service
public class ExpedienteEmpleadoServiceImpl implements ExpedienteEmpleadoService {
    @Autowired
    private ExpedienteEmpleadoRepository expedienteEmpleadoRepository;

    @Override
    public ExpedienteEmpleado save(ExpedienteEmpleado expedienteEmpleado) {
        return expedienteEmpleadoRepository.save(expedienteEmpleado);
    }

    @Override
    public List<ExpedienteEmpleado> list(){
        return (List<ExpedienteEmpleado>) expedienteEmpleadoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        expedienteEmpleadoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return expedienteEmpleadoRepository.existsById(id);
    }
}
