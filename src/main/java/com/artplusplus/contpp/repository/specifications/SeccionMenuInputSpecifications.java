package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.SeccionMenuInput;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SeccionMenuInputSpecifications implements Specification<SeccionMenuInput>{
    private SeccionMenuInput seccionMenuInput = null;

    public SeccionMenuInputSpecifications(SeccionMenuInput seccionMenuInput){
        this.seccionMenuInput = seccionMenuInput;
    }

    @Override
    public Predicate toPredicate(Root<SeccionMenuInput> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(seccionMenuInput.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"), seccionMenuInput.getId()));
        }
        if(seccionMenuInput.getInputType() != null){
            predicates.add(criteriaBuilder.equal(root.get("inputType"), seccionMenuInput.getInputType()));
        }
        if(seccionMenuInput.getInputName() != null){
            predicates.add(criteriaBuilder.equal(root.get("inputName"), seccionMenuInput.getInputName()));
        }
        if(seccionMenuInput.getSeccionMenu() != null && seccionMenuInput.getSeccionMenu().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("seccionMenu").get("id"), 
                seccionMenuInput.getSeccionMenu().getId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
