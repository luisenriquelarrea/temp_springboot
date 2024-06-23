package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Empleado;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmpleadoSpecifications implements Specification<Empleado>{
    private Empleado empleado = null;

    public EmpleadoSpecifications(Empleado empleado){
        this.empleado = empleado;
    }

    @Override
    public Predicate toPredicate(Root<Empleado> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(empleado.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"), empleado.getId()));
        }
        if(empleado.getRfc() != null){
            predicates.add(criteriaBuilder.equal(root.get("rfc"), empleado.getRfc()));
        }
        if(empleado.getCurp() != null){
            predicates.add(criteriaBuilder.equal(root.get("curp"), empleado.getCurp()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
