package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.repository.AccionGrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionGrupoServiceImpl implements AccionGrupoService {
    @Autowired private AccionGrupoRepository accionGrupoRepository;

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
    public List<AccionGrupo> filteredList(Specification<AccionGrupo> specs){
        return (List<AccionGrupo>) accionGrupoRepository.findAll(specs);
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
    public List<Accion> getAllowedExportData(Long grupoId, Long seccionMenuId) {
        return (List<Accion>) accionGrupoRepository.getAllowedExportData(grupoId, seccionMenuId);
    }

    @Override
    public List<Accion> getAllowedTableActions(Long grupoId, Long seccionMenuId) {
        return (List<Accion>) accionGrupoRepository.getAllowedTableActions(grupoId, seccionMenuId);
    }
}
