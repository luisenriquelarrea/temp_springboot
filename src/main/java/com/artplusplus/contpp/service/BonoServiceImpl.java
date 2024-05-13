package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Bono;
import com.artplusplus.contpp.repository.BonoRepository;

import java.util.List;

@Service
public class BonoServiceImpl implements BonoService {
    @Autowired
    private BonoRepository bonoRepository;

    @Override
    public Bono save(Bono bono) {
        return bonoRepository.save(bono);
    }

    @Override
    public List<Bono> list(){
        return (List<Bono>) bonoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        bonoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return bonoRepository.existsById(id);
    }
}
