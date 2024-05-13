package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.RiesgoPuesto;
import com.artplusplus.contpp.repository.RiesgoPuestoRepository;

import java.util.List;

@Service
public class RiesgoPuestoServiceImpl implements RiesgoPuestoService {
    @Autowired
    private RiesgoPuestoRepository riesgoPuestoRepository;

    @Override
    public RiesgoPuesto save(RiesgoPuesto riesgoPuesto) {
        return riesgoPuestoRepository.save(riesgoPuesto);
    }

    @Override
    public List<RiesgoPuesto> list(){
        return (List<RiesgoPuesto>) riesgoPuestoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        riesgoPuestoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return riesgoPuestoRepository.existsById(id);
    }
}
