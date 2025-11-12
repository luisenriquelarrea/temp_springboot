package com.artplusplus.contpp.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.StyledColumn;
import com.artplusplus.contpp.dto.StyledColumnDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class StyledColumnSpecifications implements Specification<StyledColumn>{
    private StyledColumnDto styledColumnDto = null;

    public StyledColumnSpecifications(StyledColumnDto styledColumnDto){
        this.styledColumnDto = styledColumnDto;
    }

    @Override
    public Predicate toPredicate(Root<StyledColumn> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
