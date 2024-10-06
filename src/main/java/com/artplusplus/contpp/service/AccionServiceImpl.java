package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.AccionDto;
import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.repository.AccionRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class AccionServiceImpl implements AccionService {
    @Autowired
    private AccionRepository accionRepository;

    @Override
    public Accion save(Accion accion) {
        return accionRepository.save(accion);
    }

    @Override
    public List<Accion> list(){
        return (List<Accion>) accionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        accionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return accionRepository.existsById(id);
    }

    @Override
    public Accion getById(Long id){
        return accionRepository.findById(id).get();
    }

    @Override
    public List<AccionDto> filteredList(Specification<Accion> specs, PageRequest pageRequest){
        Page<Accion> accionPage = accionRepository.findAll(specs,
            pageRequest);
        List<Accion> accion = accionPage.getContent();
        return (List<AccionDto>)
            ObjectMapperUtils.mapAll(accion, AccionDto.class);
    }

    @Override
    public long count(){
        return accionRepository.count();
    }

    @Override
    public long countFilteredList(Specification<Accion> specs){
        return accionRepository.count(specs);
    }
}
