package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.PagoDescuento;
import com.artplusplus.contpp.repository.PagoDescuentoRepository;

import java.util.List;

@Service
public class PagoDescuentoServiceImpl implements PagoDescuentoService {
    @Autowired
    private PagoDescuentoRepository pagoDescuentoRepository;

    @Override
    public PagoDescuento save(PagoDescuento pagoDescuento) {
        return pagoDescuentoRepository.save(pagoDescuento);
    }

    @Override
    public List<PagoDescuento> list(){
        return (List<PagoDescuento>) pagoDescuentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        pagoDescuentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pagoDescuentoRepository.existsById(id);
    }
}
