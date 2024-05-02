package com.mycompany.utilities.dto;

import com.mycompany.utilities.dto.enums.ColorEnum;
import com.mycompany.utilities.dto.enums.MaterialEnum;
import java.util.List;

public class ProductoDto {

    private Long id_producto;
    private String nombre;
    private String descrpcion;
    private String marca;
    private MaterialEnum material;
    private ColorEnum color;
    private String codigo;
    private float precio;
    private CategoriaDto categoriaDto;
    private List<ImagenDto> imagenesDtos;
    private EstiloDto estiloDto;
    private List<Long> id_productos_tallas;
    private List<Long> id_carritos;
    private List<Long> id_pedidos_productos;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, String descrpcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, CategoriaDto categoriaDto, List<ImagenDto> imagenesDtos, EstiloDto estiloDto, List<Long> id_productos_tallas) {
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoriaDto = categoriaDto;
        this.imagenesDtos = imagenesDtos;
        this.estiloDto = estiloDto;
        this.id_productos_tallas = id_productos_tallas;
    }

    public ProductoDto(Long id_producto, String nombre, String descrpcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, CategoriaDto categoriaDto, List<ImagenDto> imagenesDtos, EstiloDto estiloDto, List<Long> id_productos_tallas, List<Long> id_carritos, List<Long> id_pedidos_productos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descrpcion = descrpcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoriaDto = categoriaDto;
        this.imagenesDtos = imagenesDtos;
        this.estiloDto = estiloDto;
        this.id_productos_tallas = id_productos_tallas;
        this.id_carritos = id_carritos;
        this.id_pedidos_productos = id_pedidos_productos;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public MaterialEnum getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public CategoriaDto getCategoriaDto() {
        return categoriaDto;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        this.categoriaDto = categoriaDto;
    }

    public List<ImagenDto> getImagenesDtos() {
        return imagenesDtos;
    }

    public void setImagenesDtos(List<ImagenDto> imagenesDtos) {
        this.imagenesDtos = imagenesDtos;
    }

    public EstiloDto getEstiloDto() {
        return estiloDto;
    }

    public void setEstiloDto(EstiloDto estiloDto) {
        this.estiloDto = estiloDto;
    }

    public List<Long> getId_productos_tallas() {
        return id_productos_tallas;
    }

    public void setId_productos_tallas(List<Long> id_productos_tallas) {
        this.id_productos_tallas = id_productos_tallas;
    }

    public List<Long> getId_carritos() {
        return id_carritos;
    }

    public void setId_carritos(List<Long> id_carritos) {
        this.id_carritos = id_carritos;
    }

    public List<Long> getId_pedidos_productos() {
        return id_pedidos_productos;
    }

    public void setId_pedidos_productos(List<Long> id_pedidos_productos) {
        this.id_pedidos_productos = id_pedidos_productos;
    }

}
