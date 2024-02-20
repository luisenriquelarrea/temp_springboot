package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Plaza;
import com.artplusplus.contpp.repository.PlazaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlazaServiceImpl implements PlazaService {
    @Autowired private PlazaRepository plazaRepository;

    public Plaza savePlaza(Plaza plaza){
        return plazaRepository.save(plaza);
    }

    public List<Plaza> listPlaza(){
        return (List<Plaza>) plazaRepository.findAll();
    }

    public void deletePlaza(Long id){
        plazaRepository.deleteById(id);
    }

    public boolean getById(Long id){
        return plazaRepository.existsById(id);
    }

    public Plaza plazaById(Long id){
        return plazaRepository.findById(id).get();
    }
}
