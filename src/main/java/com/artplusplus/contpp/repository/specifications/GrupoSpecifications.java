package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.dto.GrupoDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class GrupoSpecifications implements Specification<Grupo>{
    private GrupoDto grupoDto = null;

    public GrupoSpecifications(GrupoDto grupoDto){
        this.grupoDto = grupoDto;
    }

    @Override
    public Predicate toPredicate(Root<Grupo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
