package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Moneda;
import com.artplusplus.contpp.repository.MonedaRepository;

import java.util.List;

@Service
public class MonedaServiceImpl implements MonedaService {
    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public Moneda save(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public List<Moneda> list(){
        return (List<Moneda>) monedaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        monedaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return monedaRepository.existsById(id);
    }
}
