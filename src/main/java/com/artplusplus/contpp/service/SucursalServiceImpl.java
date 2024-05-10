package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Sucursal;
import com.artplusplus.contpp.repository.SucursalRepository;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired 
    private SucursalRepository sucursalRepository;

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public List<Sucursal> list(){
        return (List<Sucursal>) sucursalRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        sucursalRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return sucursalRepository.existsById(id);
    }
}
