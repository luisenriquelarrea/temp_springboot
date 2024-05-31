package com.artplusplus.contpp.repository.customMethods;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputCustomMethods {
    /*@Query("SELECT smi "+
        "FROM SeccionMenuInput smi "+
        "WHERE smi.seccionMenu.id = :seccionMenuId "+
        "AND smi.:column = 1 "+
        "AND smi.status = 1 "+
        "ORDER BY smi.orden ASC ")
    List<SeccionMenuInput> getInputs(@Param("seccionMenuId") Long seccionMenuId, 
        @Param("column") String column);*/
}
