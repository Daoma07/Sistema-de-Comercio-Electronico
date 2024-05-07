package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.util.List;

public class CategoriaDto implements Serializable {

    private Long id_categoria;
    private String nombre;
    private List<Long> id_categorias_hijas;
    private Long id_categoria_padre;
    private List<Long> id_productos;

    public CategoriaDto() {
    }

    public CategoriaDto(String nombre, List<Long> id_categorias_hijas, Long id_categoria_padre, List<Long> id_productos) {
        this.nombre = nombre;
        this.id_categorias_hijas = id_categorias_hijas;
        this.id_categoria_padre = id_categoria_padre;
        this.id_productos = id_productos;
    }

    public CategoriaDto(Long id_categoria, String nombre, List<Long> id_categorias_hijas, Long id_categoria_padre, List<Long> id_productos) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.id_categorias_hijas = id_categorias_hijas;
        this.id_categoria_padre = id_categoria_padre;
        this.id_productos = id_productos;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Long> getId_categorias_hijas() {
        return id_categorias_hijas;
    }

    public void setId_categorias_hijas(List<Long> id_categorias_hijas) {
        this.id_categorias_hijas = id_categorias_hijas;
    }

    public Long getId_categoria_padre() {
        return id_categoria_padre;
    }

    public void setId_categoria_padre(Long id_categoria_padre) {
        this.id_categoria_padre = id_categoria_padre;
    }

    public List<Long> getId_productos() {
        return id_productos;
    }

    public void setId_productos(List<Long> id_productos) {
        this.id_productos = id_productos;
    }

    @Override
    public String toString() {
        return "CategoriaDto{" + "id_categoria=" + id_categoria + ", nombre=" + nombre + ", id_categorias_hijas=" + id_categorias_hijas + ", id_categoria_padre=" + id_categoria_padre + ", id_productos=" + id_productos + '}';
    }

    
}
