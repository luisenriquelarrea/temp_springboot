package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Plaza;
import com.artplusplus.contpp.repository.PlazaRepository;

import java.util.List;

@Service
public class PlazaServiceImpl implements PlazaService {
    @Autowired 
    private PlazaRepository plazaRepository;

    @Override
    public Plaza save(Plaza plaza) {
        return plazaRepository.save(plaza);
    }

    @Override
    public List<Plaza> list(){
        return (List<Plaza>) plazaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        plazaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return plazaRepository.existsById(id);
    }
}
