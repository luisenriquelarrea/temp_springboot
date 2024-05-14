package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.SubsidioEmpleo;
import com.artplusplus.contpp.repository.SubsidioEmpleoRepository;

import java.util.List;

@Service
public class SubsidioEmpleoServiceImpl implements SubsidioEmpleoService {
    @Autowired
    private SubsidioEmpleoRepository subsidioEmpleoRepository;

    @Override
    public SubsidioEmpleo save(SubsidioEmpleo subsidioEmpleo) {
        return subsidioEmpleoRepository.save(subsidioEmpleo);
    }

    @Override
    public List<SubsidioEmpleo> list(){
        return (List<SubsidioEmpleo>) subsidioEmpleoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        subsidioEmpleoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return subsidioEmpleoRepository.existsById(id);
    }
}
