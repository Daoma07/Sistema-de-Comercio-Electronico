package com.mycompany.utilities.dto;

import com.mycompany.utilities.dto.enums.ColorEnum;
import com.mycompany.utilities.dto.enums.MaterialEnum;
import java.io.Serializable;
import java.util.List;

public class ProductoDto implements Serializable {

    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String marca;
    private MaterialEnum material;
    private ColorEnum color;
    private String codigo;
    private float precio;
    private CategoriaDto categoriaDto;
    private List<ImagenDto> imagenesDtos;
    private EstiloDto estiloDto;
    private List<ProductoTallaDto> productoTallaDtos;
    private List<Long> id_carritos;
    private List<Long> id_pedidos_productos;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, String descripcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, CategoriaDto categoriaDto, List<ImagenDto> imagenesDtos, EstiloDto estiloDto, List<ProductoTallaDto> productoTallaDtos, List<Long> id_carritos, List<Long> id_pedidos_productos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoriaDto = categoriaDto;
        this.imagenesDtos = imagenesDtos;
        this.estiloDto = estiloDto;
        this.productoTallaDtos = productoTallaDtos;
        this.id_carritos = id_carritos;
        this.id_pedidos_productos = id_pedidos_productos;
    }

    public ProductoDto(Long id_producto, String nombre, String descripcion, String marca, MaterialEnum material, ColorEnum color, String codigo, float precio, CategoriaDto categoriaDto, List<ImagenDto> imagenesDtos, EstiloDto estiloDto, List<ProductoTallaDto> productoTallaDtos, List<Long> id_carritos, List<Long> id_pedidos_productos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.material = material;
        this.color = color;
        this.codigo = codigo;
        this.precio = precio;
        this.categoriaDto = categoriaDto;
        this.imagenesDtos = imagenesDtos;
        this.estiloDto = estiloDto;
        this.productoTallaDtos = productoTallaDtos;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<ProductoTallaDto> getProductoTallaDtos() {
        return productoTallaDtos;
    }

    public void setProductoTallaDtos(List<ProductoTallaDto> productoTallaDtos) {
        this.productoTallaDtos = productoTallaDtos;
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

    @Override
    public String toString() {
        return "ProductoDto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca + ", material=" + material + ", color=" + color + ", codigo=" + codigo + ", precio=" + precio + ", categoriaDto=" + categoriaDto + ", imagenesDtos=" + imagenesDtos + ", estiloDto=" + estiloDto + ", productoTallaDtos=" + productoTallaDtos + ", id_carritos=" + id_carritos + ", id_pedidos_productos=" + id_pedidos_productos + '}';
    }

}
