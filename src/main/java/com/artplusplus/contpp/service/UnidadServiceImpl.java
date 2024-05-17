package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Unidad;
import com.artplusplus.contpp.repository.UnidadRepository;

import java.util.List;

@Service
public class UnidadServiceImpl implements UnidadService {
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public Unidad save(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    @Override
    public List<Unidad> list(){
        return (List<Unidad>) unidadRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        unidadRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return unidadRepository.existsById(id);
    }
}
