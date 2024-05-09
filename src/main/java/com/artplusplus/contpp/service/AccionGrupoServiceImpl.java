package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

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
    public List<AccionGrupo> list(){
        return (List<AccionGrupo>) accionGrupoRepository.findAll();
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
