package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.GrupoDto;
import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.repository.GrupoRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public List<Grupo> list(){
        return (List<Grupo>) grupoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        grupoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return grupoRepository.existsById(id);
    }

    @Override
    public Grupo getById(Long id){
        return grupoRepository.findById(id).get();
    }

    @Override
    public List<GrupoDto> filteredList(Specification<Grupo> specs, PageRequest pageRequest){
        Page<Grupo> grupoPage = grupoRepository.findAll(specs,
            pageRequest);
        List<Grupo> grupo = grupoPage.getContent();
        return (List<GrupoDto>)
            ObjectMapperUtils.mapAll(grupo, GrupoDto.class);
    }

    @Override
    public long count(){
        return grupoRepository.count();
    }

    @Override
    public long countFilteredList(Specification<Grupo> specs){
        return grupoRepository.count(specs);
    }
}
