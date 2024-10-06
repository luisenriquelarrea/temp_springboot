package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.SeccionMenuDto;
import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.repository.SeccionMenuRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class SeccionMenuServiceImpl implements SeccionMenuService {
    @Autowired
    private SeccionMenuRepository seccionMenuRepository;

    @Override
    public SeccionMenu save(SeccionMenu seccionMenu) {
        return seccionMenuRepository.save(seccionMenu);
    }

    @Override
    public List<SeccionMenu> list(){
        return (List<SeccionMenu>) seccionMenuRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        seccionMenuRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return seccionMenuRepository.existsById(id);
    }

    @Override
    public SeccionMenu getById(Long id){
        return seccionMenuRepository.findById(id).get();
    }

    @Override
    public List<SeccionMenuDto> filteredList(Specification<SeccionMenu> specs, PageRequest pageRequest){
        Page<SeccionMenu> seccionMenuPage = seccionMenuRepository.findAll(specs,
            pageRequest);
        List<SeccionMenu> seccionMenu = seccionMenuPage.getContent();
        return (List<SeccionMenuDto>)
            ObjectMapperUtils.mapAll(seccionMenu, SeccionMenuDto.class);
    }

    @Override
    public long count(){
        return seccionMenuRepository.count();
    }

    @Override
    public long countFilteredList(Specification<SeccionMenu> specs){
        return seccionMenuRepository.count(specs);
    }
}
