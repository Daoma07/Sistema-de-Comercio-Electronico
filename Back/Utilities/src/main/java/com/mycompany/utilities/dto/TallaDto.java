package com.mycompany.utilities.dto;

import java.util.List;

public class TallaDto {

    private Long id_talla;
    private String talla_us;
    private String talla_mx;
    private List<Long> id_productos_tallas;

    public TallaDto() {
    }

    public TallaDto(String talla_us, String talla_mx, List<Long> id_productos_tallas) {
        this.talla_us = talla_us;
        this.talla_mx = talla_mx;
        this.id_productos_tallas = id_productos_tallas;
    }

    public TallaDto(Long id_talla, String talla_us, String talla_mx, List<Long> id_productos_tallas) {
        this.id_talla = id_talla;
        this.talla_us = talla_us;
        this.talla_mx = talla_mx;
        this.id_productos_tallas = id_productos_tallas;
    }

    public Long getId_talla() {
        return id_talla;
    }

    public void setId_talla(Long id_talla) {
        this.id_talla = id_talla;
    }

    public String getTalla_us() {
        return talla_us;
    }

    public void setTalla_us(String talla_us) {
        this.talla_us = talla_us;
    }

    public String getTalla_mx() {
        return talla_mx;
    }

    public void setTalla_mx(String talla_mx) {
        this.talla_mx = talla_mx;
    }

    public List<Long> getId_productos_tallas() {
        return id_productos_tallas;
    }

    public void setId_productos_tallas(List<Long> id_productos_tallas) {
        this.id_productos_tallas = id_productos_tallas;
    }

}
