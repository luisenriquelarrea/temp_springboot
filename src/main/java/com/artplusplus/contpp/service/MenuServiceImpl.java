package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.MenuDto;
import com.artplusplus.contpp.model.Menu;
import com.artplusplus.contpp.repository.MenuRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> list(){
        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        menuRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return menuRepository.existsById(id);
    }

    @Override
    public Menu getById(Long id){
        return menuRepository.findById(id).get();
    }

    @Override
    public List<MenuDto> filteredList(Specification<Menu> specs, PageRequest pageRequest){
        Page<Menu> menuPage = menuRepository.findAll(specs,
            pageRequest);
        List<Menu> menu = menuPage.getContent();
        return (List<MenuDto>)
            ObjectMapperUtils.mapAll(menu, MenuDto.class);
    }

    @Override
    public long count(){
        return menuRepository.count();
    }

    @Override
    public long countFilteredList(Specification<Menu> specs){
        return menuRepository.count(specs);
    }
}
