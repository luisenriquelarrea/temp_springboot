package com.artplusplus.contpp.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.dto.SeccionMenuInputDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SeccionMenuInputSpecifications implements Specification<SeccionMenuInput>{
    private SeccionMenuInputDto seccionMenuInputDto = null;

    public SeccionMenuInputSpecifications(SeccionMenuInputDto seccionMenuInputDto){
        this.seccionMenuInputDto = seccionMenuInputDto;
    }

    @Override
    public Predicate toPredicate(Root<SeccionMenuInput> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
