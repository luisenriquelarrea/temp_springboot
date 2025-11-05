package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputRepository extends JpaRepository<SeccionMenuInput, Long>, JpaSpecificationExecutor<SeccionMenuInput> {
    @Modifying
    @Query("""
        UPDATE SeccionMenuInput s 
        SET s.orden = s.orden + 1 
        WHERE s.seccionMenu.id = :seccionMenuId 
          AND s.orden >= :startOrden
    """)
    void shiftOrdenUp(@Param("seccionMenuId") Long seccionMenuId,
                      @Param("startOrden") int startOrden);

    @Modifying
    @Query("""
        UPDATE SeccionMenuInput s 
        SET s.orden = s.orden - 1 
        WHERE s.seccionMenu.id = :seccionMenuId 
          AND s.orden > :oldOrden 
          AND s.orden <= :newOrden
    """)
    void shiftOrdenDown(@Param("seccionMenuId") Long seccionMenuId,
                        @Param("oldOrden") int oldOrden,
                        @Param("newOrden") int newOrden);
}
