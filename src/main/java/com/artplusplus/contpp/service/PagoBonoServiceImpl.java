package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.PagoBono;
import com.artplusplus.contpp.repository.PagoBonoRepository;

import java.util.List;

@Service
public class PagoBonoServiceImpl implements PagoBonoService {
    @Autowired
    private PagoBonoRepository pagoBonoRepository;

    @Override
    public PagoBono save(PagoBono pagoBono) {
        return pagoBonoRepository.save(pagoBono);
    }

    @Override
    public List<PagoBono> list(){
        return (List<PagoBono>) pagoBonoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        pagoBonoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pagoBonoRepository.existsById(id);
    }
}
