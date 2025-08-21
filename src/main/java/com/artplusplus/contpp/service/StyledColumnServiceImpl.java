package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.dto.StyledColumnDto;
import com.artplusplus.contpp.model.StyledColumn;
import com.artplusplus.contpp.repository.StyledColumnRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class StyledColumnServiceImpl implements StyledColumnService {
    @Autowired
    private StyledColumnRepository styledColumnRepository;

    @Override
    public StyledColumn save(StyledColumn styledColumn) {
        return styledColumnRepository.save(styledColumn);
    }

    @Override
    public List<StyledColumn> list(){
        return (List<StyledColumn>) styledColumnRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        styledColumnRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return styledColumnRepository.existsById(id);
    }

    @Override
    public StyledColumn getById(Long id){
        return styledColumnRepository.findById(id).get();
    }

    @Override
    public List<StyledColumnDto> filteredList(Specification<StyledColumn> specs, PageRequest pageRequest){
        Page<StyledColumn> styledColumnPage = styledColumnRepository.findAll(specs,
            pageRequest);
        List<StyledColumn> styledColumn = styledColumnPage.getContent();
        return (List<StyledColumnDto>)
            ObjectMapperUtils.mapAll(styledColumn, StyledColumnDto.class);
    }

    @Override
    public long count(){
        return styledColumnRepository.count();
    }

    @Override
    public long countFilteredList(Specification<StyledColumn> specs){
        return styledColumnRepository.count(specs);
    }
}
