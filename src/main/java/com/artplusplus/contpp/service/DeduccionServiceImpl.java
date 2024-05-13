package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Deduccion;
import com.artplusplus.contpp.repository.DeduccionRepository;

import java.util.List;

@Service
public class DeduccionServiceImpl implements DeduccionService {
    @Autowired
    private DeduccionRepository deduccionRepository;

    @Override
    public Deduccion save(Deduccion deduccion) {
        return deduccionRepository.save(deduccion);
    }

    @Override
    public List<Deduccion> list(){
        return (List<Deduccion>) deduccionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        deduccionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return deduccionRepository.existsById(id);
    }
}
