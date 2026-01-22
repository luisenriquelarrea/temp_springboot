package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artplusplus.contpp.dto.SeccionMenuInputDto;
import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.repository.SeccionMenuInputRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class SeccionMenuInputServiceImpl implements SeccionMenuInputService {
    @Autowired
    private SeccionMenuInputRepository repository;

    @Override
    public SeccionMenuInput save(SeccionMenuInput seccionMenuInput) {
        return repository.save(seccionMenuInput);
    }

    @Override
    public List<SeccionMenuInput> list(){
        return (List<SeccionMenuInput>) repository.findAll();
    }

    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public SeccionMenuInput getById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<SeccionMenuInputDto> filteredList(Specification<SeccionMenuInput> specs, PageRequest pageRequest){
        Page<SeccionMenuInput> seccionMenuInputPage = repository.findAll(specs, pageRequest);
        List<SeccionMenuInput> seccionMenuInputList = seccionMenuInputPage.getContent();
        return ObjectMapperUtils.mapAll(seccionMenuInputList, SeccionMenuInputDto.class);
    }

    @Override
    public long count(){
        return repository.count();
    }

    @Override
    public long countFilteredList(Specification<SeccionMenuInput> specs){
        return repository.count(specs);
    }

    @Override
    public List<SeccionMenuInput> getBySeccionMenu(Long seccionMenuId){
        return repository.findBySeccionMenuId(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsAlta(Long seccionMenuId){
        return repository.findActiveInputsAlta(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsModifica(Long seccionMenuId){
        return repository.findActiveInputsModifica(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsLista(Long seccionMenuId){
        return repository.findActiveInputsLista(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsVista(Long seccionMenuId){
        return repository.findActiveInputsVista(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsFiltro(Long seccionMenuId){
        return repository.findActiveInputsFiltro(seccionMenuId);
    }

    @Override
    public List<SeccionMenuInput> getInputsEncabezado(Long seccionMenuId){
        return repository.findActiveInputsEncabezado(seccionMenuId);
    }

    @Override
    @Transactional
    public SeccionMenuInput saveOrUpdate(SeccionMenuInput input) {
        Long seccionMenuId = input.getSeccionMenu().getId();
        int newOrden = input.getOrden();

        if (input.getId() == null) {
            repository.shiftOrdenUp(seccionMenuId, newOrden);
            return repository.save(input);
        } else {
            SeccionMenuInput existing = repository.findById(input.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Record not found"));

            int oldOrden = existing.getOrden();

            if (oldOrden == newOrden) {
                return repository.save(input);
            }

            if (newOrden < oldOrden) {
                repository.shiftOrdenUp(seccionMenuId, newOrden);
            } else {
                repository.shiftOrdenDown(seccionMenuId, oldOrden, newOrden);
            }

            return repository.save(input);
        }
    }
}
