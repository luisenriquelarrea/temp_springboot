package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Concepto;
import com.artplusplus.contpp.repository.ConceptoRepository;

import java.util.List;

@Service
public class ConceptoServiceImpl implements ConceptoService {
    @Autowired
    private ConceptoRepository conceptoRepository;

    @Override
    public Concepto save(Concepto concepto) {
        return conceptoRepository.save(concepto);
    }

    @Override
    public List<Concepto> list(){
        return (List<Concepto>) conceptoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        conceptoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return conceptoRepository.existsById(id);
    }
}
