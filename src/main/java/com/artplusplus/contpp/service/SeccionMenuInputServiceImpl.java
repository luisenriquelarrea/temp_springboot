package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.repository.SeccionMenuInputRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionMenuInputServiceImpl implements SeccionMenuInputService {
    @Autowired 
    private SeccionMenuInputRepository seccionMenuInputRepository;

    @Override
    public SeccionMenuInput save(SeccionMenuInput seccionMenuInput) {
        return seccionMenuInputRepository.save(seccionMenuInput);
    }

    @Override
    public List<SeccionMenuInput> list(){
        return (List<SeccionMenuInput>) seccionMenuInputRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        seccionMenuInputRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return seccionMenuInputRepository.existsById(id);
    }

    @Override
    public List<SeccionMenuInput> getBySeccionMenu(Long seccionMenuId){
        return (List<SeccionMenuInput>) seccionMenuInputRepository.findBySeccionMenuId(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsAlta(Long seccionMenuId){
        return (List<SeccionMenuInput>) 
            seccionMenuInputRepository.findBySeccionMenuIdAndAltaAndStatus(seccionMenuId, 1, 1);
    }

    @Override
    public List<SeccionMenuInput> getInputsModifica(Long seccionMenuId){
        return (List<SeccionMenuInput>) 
            seccionMenuInputRepository.findBySeccionMenuIdAndModificaAndStatus(seccionMenuId, 1, 1);
    }

    @Override
    public List<SeccionMenuInput> getInputsLista(Long seccionMenuId){
        return (List<SeccionMenuInput>) 
            seccionMenuInputRepository.findBySeccionMenuIdAndListaAndStatus(seccionMenuId, 1, 1);
    }

    @Override
    public List<SeccionMenuInput> getInputsFiltro(Long seccionMenuId){
        return (List<SeccionMenuInput>) 
            seccionMenuInputRepository.findBySeccionMenuIdAndFiltroAndStatus(seccionMenuId, 1, 1);
    }
}
