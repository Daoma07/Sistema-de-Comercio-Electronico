package com.mycompany.utilities.dto;

import java.io.Serializable;

public class CarritoDto implements Serializable {

    private Long id_carrito;
    private float importe;
    private float precio_unidad;
    private int cantidad;
    private Long id_usuario;
    private ProductoDto productoDto;

    public CarritoDto() {
    }

    public CarritoDto(float importe, float precio_unidad, int cantidad, Long id_usuario, ProductoDto productoDto) {
        this.importe = importe;
        this.precio_unidad = precio_unidad;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.productoDto = productoDto;
    }

    public CarritoDto(Long id_carrito, float importe, float precio_unidad, int cantidad, Long id_usuario, ProductoDto productoDto) {
        this.id_carrito = id_carrito;
        this.importe = importe;
        this.precio_unidad = precio_unidad;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.productoDto = productoDto;
    }

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(float precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
    }

    @Override
    public String toString() {
        return "CarritoDto{" + "id_carrito=" + id_carrito + ", importe=" + importe + ", precio_unidad=" + precio_unidad + ", cantidad=" + cantidad + ", id_usuario=" + id_usuario + ", productoDto=" + productoDto + '}';
    }

}
