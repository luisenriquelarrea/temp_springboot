package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.AccionGrupoDto;
import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.repository.AccionGrupoRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionGrupoServiceImpl implements AccionGrupoService {
    @Autowired
    private AccionGrupoRepository accionGrupoRepository;

    @Override
    public AccionGrupo save(AccionGrupo accionGrupo) {
        return accionGrupoRepository.save(accionGrupo);
    }

    @Override
    public List<AccionGrupo> list(){
        return (List<AccionGrupo>) accionGrupoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        accionGrupoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return accionGrupoRepository.existsById(id);
    }

    @Override
    public AccionGrupo getById(Long id){
        return accionGrupoRepository.findById(id).get();
    }

    @Override
    public List<AccionGrupoDto> filteredList(Specification<AccionGrupo> specs, PageRequest pageRequest){
        Page<AccionGrupo> accionGrupoPage = accionGrupoRepository.findAll(specs,
            pageRequest);
        List<AccionGrupo> accionGrupo = accionGrupoPage.getContent();
        return (List<AccionGrupoDto>)
            ObjectMapperUtils.mapAll(accionGrupo, AccionGrupoDto.class);
    }

    @Override
    public long count(){
        return accionGrupoRepository.count();
    }

    @Override
    public long countFilteredList(Specification<AccionGrupo> specs){
        return accionGrupoRepository.count(specs);
    }

    @Override
    public List<SeccionMenu> getAllowedMenus(Long grupoId){
        return (List<SeccionMenu>) accionGrupoRepository.getAllowedMenus(grupoId);
    }

    @Override
    public List<Accion> getAllowedBreadcrumbs(Long grupoId, Long seccionMenuId) {
        return (List<Accion>) accionGrupoRepository.getAllowedBreadcrumbs(grupoId, seccionMenuId);
    }

    @Override
    public List<Accion> getAllowedNavbar(Long grupoId, Long seccionMenuId) {
        return (List<Accion>) accionGrupoRepository.getAllowedNavbar(grupoId, seccionMenuId);
    }

    @Override
    public List<Accion> getAllowedTableActions(Long grupoId, Long seccionMenuId) {
        return (List<Accion>) accionGrupoRepository.getAllowedTableActions(grupoId, seccionMenuId);
    }
}