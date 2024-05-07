package com.mycompany.utilities.dto;

import java.io.Serializable;

public class DireccionDto implements Serializable {

    private Long id_direccion;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String codigo_postal;
    private Long id_usaurio;

    public DireccionDto() {
    }

    public DireccionDto(String calle, String numero, String colonia,
            String ciudad, String estado, String codigo_postal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;

    }

    public DireccionDto(Long id_direccion, String calle, String numero,
            String colonia, String ciudad, String estado, String codigo_postal) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
    }

    public DireccionDto(Long id_direccion, String calle, String numero, String colonia, String ciudad, String estado, String codigo_postal, Long id_usaurio) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
        this.id_usaurio = id_usaurio;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Long getId_usaurio() {
        return id_usaurio;
    }

    public void setId_usaurio(Long id_usaurio) {
        this.id_usaurio = id_usaurio;
    }

    @Override
    public String toString() {
        return "DireccionDto{" + "id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", codigo_postal=" + codigo_postal + ", id_usaurio=" + id_usaurio + '}';
    }

    
}
