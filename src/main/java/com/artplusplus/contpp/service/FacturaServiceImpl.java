package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Factura;
import com.artplusplus.contpp.repository.FacturaRepository;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public List<Factura> list(){
        return (List<Factura>) facturaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        facturaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return facturaRepository.existsById(id);
    }
}
