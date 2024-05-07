package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.repository.AccionGrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionGrupoServiceImpl implements AccionGrupoService {
    @Autowired private AccionGrupoRepository accionGrupoRepository;

    @Override
    public List<AccionGrupo> list(){
        return (List<AccionGrupo>) accionGrupoRepository.findAll();
    }

    @Override
    public List<AccionGrupo> listByGrupo(Long grupoId){
        return (List<AccionGrupo>) accionGrupoRepository.findByGrupoIdAndAccionOnNavbar(grupoId, 1);
    }
}
