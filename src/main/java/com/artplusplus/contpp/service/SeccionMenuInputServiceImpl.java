package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.repository.SeccionMenuInputRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionMenuInputServiceImpl implements SeccionMenuInputService {
    @Autowired private SeccionMenuInputRepository seccionMenuInputRepository;

    @Override
    public List<SeccionMenuInput> list(){
        return (List<SeccionMenuInput>) seccionMenuInputRepository.findAll();
    }
}
