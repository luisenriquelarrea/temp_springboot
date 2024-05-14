package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.PrenominaDetalle;
import com.artplusplus.contpp.repository.PrenominaDetalleRepository;

import java.util.List;

@Service
public class PrenominaDetalleServiceImpl implements PrenominaDetalleService {
    @Autowired
    private PrenominaDetalleRepository prenominaDetalleRepository;

    @Override
    public PrenominaDetalle save(PrenominaDetalle prenominaDetalle) {
        return prenominaDetalleRepository.save(prenominaDetalle);
    }

    @Override
    public List<PrenominaDetalle> list(){
        return (List<PrenominaDetalle>) prenominaDetalleRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        prenominaDetalleRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return prenominaDetalleRepository.existsById(id);
    }
}
