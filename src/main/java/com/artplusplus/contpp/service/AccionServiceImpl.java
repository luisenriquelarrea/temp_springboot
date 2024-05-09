package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.repository.AccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionServiceImpl implements AccionService {
    @Autowired 
    private AccionRepository accionRepository;

    @Override
    public Accion save(Accion accion) {
        return accionRepository.save(accion);
    }

    @Override
    public List<Accion> list(){
        return (List<Accion>) accionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        accionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return accionRepository.existsById(id);
    }
}
