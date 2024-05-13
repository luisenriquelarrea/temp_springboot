package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Percepcion;
import com.artplusplus.contpp.repository.PercepcionRepository;

import java.util.List;

@Service
public class PercepcionServiceImpl implements PercepcionService {
    @Autowired
    private PercepcionRepository percepcionRepository;

    @Override
    public Percepcion save(Percepcion percepcion) {
        return percepcionRepository.save(percepcion);
    }

    @Override
    public List<Percepcion> list(){
        return (List<Percepcion>) percepcionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        percepcionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return percepcionRepository.existsById(id);
    }
}
