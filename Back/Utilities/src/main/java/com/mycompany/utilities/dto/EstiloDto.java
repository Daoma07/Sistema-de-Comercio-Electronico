package com.mycompany.utilities.dto;

import java.util.List;

public class EstiloDto {

    private Long id_estilo;
    private String nombre;
    private List<Long> id_productos;

    public EstiloDto() {
    }

    public EstiloDto(String nombre, List<Long> id_productos) {
        this.nombre = nombre;
        this.id_productos = id_productos;
    }

    public EstiloDto(Long id_estilo, String nombre, List<Long> id_productos) {
        this.id_estilo = id_estilo;
        this.nombre = nombre;
        this.id_productos = id_productos;
    }

    public Long getId_estilo() {
        return id_estilo;
    }

    public void setId_estilo(Long id_estilo) {
        this.id_estilo = id_estilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Long> getId_productos() {
        return id_productos;
    }

    public void setId_productos(List<Long> id_productos) {
        this.id_productos = id_productos;
    }

}