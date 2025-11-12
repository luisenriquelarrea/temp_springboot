package com.artplusplus.contpp.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.dto.AccionDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AccionSpecifications implements Specification<Accion>{
    private AccionDto accionDto = null;

    public AccionSpecifications(AccionDto accionDto){
        this.accionDto = accionDto;
    }

    @Override
    public Predicate toPredicate(Root<Accion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
