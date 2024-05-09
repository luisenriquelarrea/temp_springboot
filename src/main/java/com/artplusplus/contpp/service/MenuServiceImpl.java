package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Menu;
import com.artplusplus.contpp.repository.MenuRepository;
import org.springframework.stereotype.Service;

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
}
