package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Prenomina;
import com.artplusplus.contpp.repository.PrenominaRepository;

import java.util.List;

@Service
public class PrenominaServiceImpl implements PrenominaService {
    @Autowired
    private PrenominaRepository prenominaRepository;

    @Override
    public Prenomina save(Prenomina prenomina) {
        return prenominaRepository.save(prenomina);
    }

    @Override
    public List<Prenomina> list(){
        return (List<Prenomina>) prenominaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        prenominaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return prenominaRepository.existsById(id);
    }
}
