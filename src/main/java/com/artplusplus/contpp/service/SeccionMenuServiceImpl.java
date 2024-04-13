package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.repository.SeccionMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionMenuServiceImpl implements SeccionMenuService {
    @Autowired private SeccionMenuRepository seccionMenuRepository;

    @Override
    public List<SeccionMenu> listSeccionMenu(){
        return (List<SeccionMenu>) seccionMenuRepository.findAll();
    }


    @Override
    public boolean getById(Long id){
        return seccionMenuRepository.existsById(id);
    }

    @Override
    public SeccionMenu seccionMenuById(Long id){
        return seccionMenuRepository.findById(id).get();
    }
}
