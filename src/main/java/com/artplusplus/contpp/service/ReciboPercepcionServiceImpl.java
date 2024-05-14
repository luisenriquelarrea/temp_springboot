package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ReciboPercepcion;
import com.artplusplus.contpp.repository.ReciboPercepcionRepository;

import java.util.List;

@Service
public class ReciboPercepcionServiceImpl implements ReciboPercepcionService {
    @Autowired
    private ReciboPercepcionRepository reciboPercepcionRepository;

    @Override
    public ReciboPercepcion save(ReciboPercepcion reciboPercepcion) {
        return reciboPercepcionRepository.save(reciboPercepcion);
    }

    @Override
    public List<ReciboPercepcion> list(){
        return (List<ReciboPercepcion>) reciboPercepcionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        reciboPercepcionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reciboPercepcionRepository.existsById(id);
    }
}
