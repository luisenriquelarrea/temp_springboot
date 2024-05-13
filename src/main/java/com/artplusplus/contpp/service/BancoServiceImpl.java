package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Banco;
import com.artplusplus.contpp.repository.BancoRepository;

import java.util.List;

@Service
public class BancoServiceImpl implements BancoService {
    @Autowired
    private BancoRepository bancoRepository;

    @Override
    public Banco save(Banco banco) {
        return bancoRepository.save(banco);
    }

    @Override
    public List<Banco> list(){
        return (List<Banco>) bancoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        bancoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return bancoRepository.existsById(id);
    }
}
