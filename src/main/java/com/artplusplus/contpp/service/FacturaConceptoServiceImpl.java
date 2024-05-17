package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.FacturaConcepto;
import com.artplusplus.contpp.repository.FacturaConceptoRepository;

import java.util.List;

@Service
public class FacturaConceptoServiceImpl implements FacturaConceptoService {
    @Autowired
    private FacturaConceptoRepository facturaConceptoRepository;

    @Override
    public FacturaConcepto save(FacturaConcepto facturaConcepto) {
        return facturaConceptoRepository.save(facturaConcepto);
    }

    @Override
    public List<FacturaConcepto> list(){
        return (List<FacturaConcepto>) facturaConceptoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        facturaConceptoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return facturaConceptoRepository.existsById(id);
    }
}
