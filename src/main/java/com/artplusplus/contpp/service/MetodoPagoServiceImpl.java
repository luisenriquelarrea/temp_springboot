package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.MetodoPago;
import com.artplusplus.contpp.repository.MetodoPagoRepository;

import java.util.List;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public List<MetodoPago> list(){
        return (List<MetodoPago>) metodoPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        metodoPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return metodoPagoRepository.existsById(id);
    }
}
