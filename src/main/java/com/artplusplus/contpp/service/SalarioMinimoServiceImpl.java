package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.SalarioMinimo;
import com.artplusplus.contpp.repository.SalarioMinimoRepository;

import java.util.List;

@Service
public class SalarioMinimoServiceImpl implements SalarioMinimoService {
    @Autowired
    private SalarioMinimoRepository salarioMinimoRepository;

    @Override
    public SalarioMinimo save(SalarioMinimo salarioMinimo) {
        return salarioMinimoRepository.save(salarioMinimo);
    }

    @Override
    public List<SalarioMinimo> list(){
        return (List<SalarioMinimo>) salarioMinimoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        salarioMinimoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return salarioMinimoRepository.existsById(id);
    }
}
