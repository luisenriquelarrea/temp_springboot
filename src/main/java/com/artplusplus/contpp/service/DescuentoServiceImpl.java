package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Descuento;
import com.artplusplus.contpp.repository.DescuentoRepository;

import java.util.List;

@Service
public class DescuentoServiceImpl implements DescuentoService {
    @Autowired
    private DescuentoRepository descuentoRepository;

    @Override
    public Descuento save(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    @Override
    public List<Descuento> list(){
        return (List<Descuento>) descuentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        descuentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return descuentoRepository.existsById(id);
    }
}
