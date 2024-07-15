package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.AccionGrupo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AccionGrupoSpecifications implements Specification<AccionGrupo>{
    private AccionGrupo accionGrupo = null;

    public AccionGrupoSpecifications(AccionGrupo accionGrupo){
        this.accionGrupo = accionGrupo;
    }

    @Override
    public Predicate toPredicate(Root<AccionGrupo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(accionGrupo.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"), accionGrupo.getId()));
        }
        if(accionGrupo.getGrupo() != null && accionGrupo.getGrupo().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("grupo").get("id"), 
                accionGrupo.getGrupo().getId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
