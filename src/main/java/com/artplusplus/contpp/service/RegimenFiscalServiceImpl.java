package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.RegimenFiscal;
import com.artplusplus.contpp.repository.RegimenFiscalRepository;

import java.util.List;

@Service
public class RegimenFiscalServiceImpl implements RegimenFiscalService {
    @Autowired
    private RegimenFiscalRepository regimenFiscalRepository;

    @Override
    public RegimenFiscal save(RegimenFiscal regimenFiscal) {
        return regimenFiscalRepository.save(regimenFiscal);
    }

    @Override
    public List<RegimenFiscal> list(){
        return (List<RegimenFiscal>) regimenFiscalRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        regimenFiscalRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return regimenFiscalRepository.existsById(id);
    }
}
