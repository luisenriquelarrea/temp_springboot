package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Empresa;
import com.artplusplus.contpp.repository.EmpresaRepository;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> list(){
        return (List<Empresa>) empresaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        empresaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return empresaRepository.existsById(id);
    }
}
