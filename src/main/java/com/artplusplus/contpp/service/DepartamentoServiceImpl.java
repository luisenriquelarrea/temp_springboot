package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Departamento;
import com.artplusplus.contpp.repository.DepartamentoRepository;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired 
    private DepartamentoRepository departamentoRepository;

    @Override
    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public List<Departamento> list(){
        return (List<Departamento>) departamentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        departamentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return departamentoRepository.existsById(id);
    }
}
