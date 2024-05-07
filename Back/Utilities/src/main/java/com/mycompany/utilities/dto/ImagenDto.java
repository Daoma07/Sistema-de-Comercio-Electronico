package com.mycompany.utilities.dto;

import java.io.Serializable;

public class ImagenDto implements Serializable {

    private Long id_imagen;
    private byte[] contenido;
    private Long id_producto;

    public ImagenDto() {
    }

    public ImagenDto(byte[] contenido, Long id_producto) {
        this.contenido = contenido;
        this.id_producto = id_producto;
    }

    public ImagenDto(Long id_imagen, byte[] contenido, Long id_producto) {
        this.id_imagen = id_imagen;
        this.contenido = contenido;
        this.id_producto = id_producto;
    }

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

}
