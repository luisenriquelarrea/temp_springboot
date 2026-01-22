package com.artplusplus.contpp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artplusplus.contpp.model.SeccionMenuInput;

public interface SeccionMenuInputRepository extends JpaRepository<SeccionMenuInput, Long>, JpaSpecificationExecutor<SeccionMenuInput> {
    List<SeccionMenuInput> findBySeccionMenuId(Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.alta = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsAlta(@Param("seccionMenuId") Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.modifica = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsModifica(@Param("seccionMenuId") Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.vista = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsVista(@Param("seccionMenuId") Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.lista = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsLista(@Param("seccionMenuId") Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.filtro = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsFiltro(@Param("seccionMenuId") Long seccionMenuId);

    @Query("""
        SELECT s
        FROM SeccionMenuInput s
        WHERE s.seccionMenu.id = :seccionMenuId
            AND s.encabezado = 1
            AND s.status = 1
        ORDER BY s.orden""")
    List<SeccionMenuInput> findActiveInputsEncabezado(@Param("seccionMenuId") Long seccionMenuId);

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
