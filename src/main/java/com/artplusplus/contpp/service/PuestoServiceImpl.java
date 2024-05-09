package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Puesto;
import com.artplusplus.contpp.repository.PuestoRepository;

import java.util.List;

@Service
public class PuestoServiceImpl implements PuestoService {
    @Autowired 
    private PuestoRepository puestoRepository;

    @Override
    public Puesto save(Puesto puesto) {
        return puestoRepository.save(puesto);
    }

    @Override
    public List<Puesto> list(){
        return (List<Puesto>) puestoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        puestoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return puestoRepository.existsById(id);
    }
}
