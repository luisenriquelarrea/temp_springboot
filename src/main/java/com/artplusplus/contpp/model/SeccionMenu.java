package com.artplusplus.contpp.model;

import jakarta.persistence.Entity;
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
@Table(name = "seccion_menu")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class SeccionMenu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String navbarLabel;
    
    @ManyToOne
    private Menu menu;
}
