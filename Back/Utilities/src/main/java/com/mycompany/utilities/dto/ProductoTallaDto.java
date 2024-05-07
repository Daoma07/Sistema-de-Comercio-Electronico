package com.mycompany.utilities.dto;

public class ProductoTallaDto {

    private Long id_producto_talla;
    private int cantidad;
    private TallaDto tallaDto;
    private Long id_producto;

    public ProductoTallaDto() {
    }

    public ProductoTallaDto(int cantidad, TallaDto tallaDto, Long id_producto) {
        this.cantidad = cantidad;
        this.tallaDto = tallaDto;
        this.id_producto = id_producto;
    }

    public ProductoTallaDto(Long id_producto_talla, int cantidad, TallaDto tallaDto, Long id_producto) {
        this.id_producto_talla = id_producto_talla;
        this.cantidad = cantidad;
        this.tallaDto = tallaDto;
        this.id_producto = id_producto;
    }

    public Long getId_producto_talla() {
        return id_producto_talla;
    }

    public void setId_producto_talla(Long id_producto_talla) {
        this.id_producto_talla = id_producto_talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TallaDto getTallaDto() {
        return tallaDto;
    }

    public void setTallaDto(TallaDto tallaDto) {
        this.tallaDto = tallaDto;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

}
