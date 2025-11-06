package com.artplusplus.contpp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accion")
@EntityListeners(AuditingEntityListener.class)
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Accion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SeccionMenu seccionMenu;

    private String descripcion;

    private String label;

    private String icon;

    private String callMethod;

    private int onBreadcrumb;

    private int onNavbar;

    private int onTable;

    private int status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private Integer userCreatedId;

    private Integer userUpdatedId;
}