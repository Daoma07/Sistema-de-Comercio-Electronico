package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.util.List;

public class TarifaEnvioDto implements Serializable {

    private Long id_tarifa_envio;
    private String desripcion;
    private Float costo;
    private List<Long> id_pedidosdto;

    public TarifaEnvioDto() {
    }

    public TarifaEnvioDto(String desripcion, Float costo, List<Long> id_pedidosdto) {
        this.desripcion = desripcion;
        this.costo = costo;
        this.id_pedidosdto = id_pedidosdto;
    }

    public TarifaEnvioDto(Long id_tarifa_envio, String desripcion, Float costo, List<Long> id_pedidosdto) {
        this.id_tarifa_envio = id_tarifa_envio;
        this.desripcion = desripcion;
        this.costo = costo;
        this.id_pedidosdto = id_pedidosdto;
    }

    public Long getId_tarifa_envio() {
        return id_tarifa_envio;
    }

    public void setId_tarifa_envio(Long id_tarifa_envio) {
        this.id_tarifa_envio = id_tarifa_envio;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public List<Long> getId_pedidosdto() {
        return id_pedidosdto;
    }

    public void setId_pedidosdto(List<Long> id_pedidosdto) {
        this.id_pedidosdto = id_pedidosdto;
    }

    @Override
    public String toString() {
        return "TarifaEnvioDto{" + "id_tarifa_envio=" + id_tarifa_envio + ", desripcion=" + desripcion + ", costo=" + costo + ", id_pedidosdto=" + id_pedidosdto + '}';
    }

}
