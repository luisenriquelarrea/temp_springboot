package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.PeriodoPago;
import com.artplusplus.contpp.repository.PeriodoPagoRepository;

import java.util.List;

@Service
public class PeriodoPagoServiceImpl implements PeriodoPagoService {
    @Autowired
    private PeriodoPagoRepository periodoPagoRepository;

    @Override
    public PeriodoPago save(PeriodoPago periodoPago) {
        return periodoPagoRepository.save(periodoPago);
    }

    @Override
    public List<PeriodoPago> list(){
        return (List<PeriodoPago>) periodoPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        periodoPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return periodoPagoRepository.existsById(id);
    }
}
