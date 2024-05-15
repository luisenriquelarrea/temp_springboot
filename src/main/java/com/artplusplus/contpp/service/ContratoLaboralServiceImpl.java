package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ContratoLaboral;
import com.artplusplus.contpp.repository.ContratoLaboralRepository;

import java.util.List;

@Service
public class ContratoLaboralServiceImpl implements ContratoLaboralService {
    @Autowired
    private ContratoLaboralRepository contratoLaboralRepository;

    @Override
    public ContratoLaboral save(ContratoLaboral contratoLaboral) {
        return contratoLaboralRepository.save(contratoLaboral);
    }

    @Override
    public List<ContratoLaboral> list(){
        return (List<ContratoLaboral>) contratoLaboralRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        contratoLaboralRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return contratoLaboralRepository.existsById(id);
    }
}
