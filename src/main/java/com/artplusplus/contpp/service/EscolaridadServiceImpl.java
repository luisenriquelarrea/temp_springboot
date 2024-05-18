package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Escolaridad;
import com.artplusplus.contpp.repository.EscolaridadRepository;

import java.util.List;

@Service
public class EscolaridadServiceImpl implements EscolaridadService {
    @Autowired
    private EscolaridadRepository escolaridadRepository;

    @Override
    public Escolaridad save(Escolaridad escolaridad) {
        return escolaridadRepository.save(escolaridad);
    }

    @Override
    public List<Escolaridad> list(){
        return (List<Escolaridad>) escolaridadRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        escolaridadRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return escolaridadRepository.existsById(id);
    }
}
