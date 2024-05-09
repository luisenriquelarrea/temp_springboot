package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.PeriodicidadPago;
import com.artplusplus.contpp.repository.PeriodicidadPagoRepository;

import java.util.List;

@Service
public class PeriodicidadPagoServiceImpl implements PeriodicidadPagoService {
    @Autowired 
    private PeriodicidadPagoRepository periodicidadPagoRepository;

    @Override
    public PeriodicidadPago save(PeriodicidadPago periodicidadPago) {
        return periodicidadPagoRepository.save(periodicidadPago);
    }

    @Override
    public List<PeriodicidadPago> list(){
        return (List<PeriodicidadPago>) periodicidadPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        periodicidadPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return periodicidadPagoRepository.existsById(id);
    }
}
