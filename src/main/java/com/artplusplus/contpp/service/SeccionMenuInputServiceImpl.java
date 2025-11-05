package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.SeccionMenuInputDto;
import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.repository.SeccionMenuInputRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

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
    public boolean existsById(Long id) {
        return seccionMenuInputRepository.existsById(id);
    }

    @Override
    public SeccionMenuInput getById(Long id){
        return seccionMenuInputRepository.findById(id).get();
    }

    @Override
    public List<SeccionMenuInputDto> filteredList(Specification<SeccionMenuInput> specs, PageRequest pageRequest){
        Page<SeccionMenuInput> seccionMenuInputPage = seccionMenuInputRepository.findAll(specs,
            pageRequest);
        List<SeccionMenuInput> seccionMenuInput = seccionMenuInputPage.getContent();
        return (List<SeccionMenuInputDto>)
            ObjectMapperUtils.mapAll(seccionMenuInput, SeccionMenuInputDto.class);
    }

    @Override
    public long count(){
        return seccionMenuInputRepository.count();
    }

    @Override
    public long countFilteredList(Specification<SeccionMenuInput> specs){
        return seccionMenuInputRepository.count(specs);
    }

    @Override
    @Transactional
    public SeccionMenuInput saveOrUpdate(SeccionMenuInput input) {
        Long seccionMenuId = input.getSeccionMenu().getId();
        int newOrden = input.getOrden();

        if (input.getId() == null) {
            seccionMenuInputRepository.shiftOrdenUp(seccionMenuId, newOrden);
            return seccionMenuInputRepository.save(input);
        } else {
            SeccionMenuInput existing = seccionMenuInputRepository.findById(input.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Record not found"));

            int oldOrden = existing.getOrden();

            if (oldOrden == newOrden) {
                return seccionMenuInputRepository.save(input);
            }

            if (newOrden < oldOrden) {
                seccionMenuInputRepository.shiftOrdenUp(seccionMenuId, newOrden);
            } else {
                seccionMenuInputRepository.shiftOrdenDown(seccionMenuId, oldOrden, newOrden);
            }

            return seccionMenuInputRepository.save(input);
        }
    }
}
