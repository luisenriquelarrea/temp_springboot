package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ComplementoPago;
import com.artplusplus.contpp.repository.ComplementoPagoRepository;

import java.util.List;

@Service
public class ComplementoPagoServiceImpl implements ComplementoPagoService {
    @Autowired
    private ComplementoPagoRepository complementoPagoRepository;

    @Override
    public ComplementoPago save(ComplementoPago complementoPago) {
        return complementoPagoRepository.save(complementoPago);
    }

    @Override
    public List<ComplementoPago> list(){
        return (List<ComplementoPago>) complementoPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        complementoPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return complementoPagoRepository.existsById(id);
    }
}
