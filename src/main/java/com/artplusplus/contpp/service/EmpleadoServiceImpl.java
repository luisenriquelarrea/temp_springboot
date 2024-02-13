package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Empleado;
import com.artplusplus.contpp.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired private EmpleadoRepository empleadoRepository;

    public Empleado saveEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> listEmpleado(){
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public Empleado updateEmpleado(Empleado empleado, Long empleadoId){
        Empleado empleadoDB = empleadoRepository.findById(empleadoId).get();
        
        if(Objects.nonNull(empleado.getNombreCompleto()) 
            && !"".equalsIgnoreCase(empleado.getNombreCompleto())){
            empleadoDB.setNombreCompleto(empleado.getNombreCompleto());
        }
        if(Objects.nonNull(empleado.getRfc()) 
            && !"".equalsIgnoreCase(empleado.getRfc())){
            empleadoDB.setRfc(empleado.getRfc());
        }
        if(Objects.nonNull(empleado.getCurp()) 
            && !"".equalsIgnoreCase(empleado.getCurp())){
            empleadoDB.setCurp(empleado.getCurp());
        }
        
        return empleadoRepository.save(empleadoDB);
    }

    public void deleteEmpleado(Long empleadoId){
        empleadoRepository.deleteById(empleadoId);
    }

    public boolean getById(Long empleadoId){
        return empleadoRepository.existsById(empleadoId);
    }
}
