package com.mycompany.utilities.dto;

import com.mycompany.utilities.dto.enums.EstatusEnum;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class PedidoDto implements Serializable {

    private Long id_pedido;
    private Timestamp fechaHora;
    private Timestamp fechaHoraEnvio;
    private Date fechaEntrega;
    private Float total;
    private EstatusEnum estatusEnum;
    private Long id_usuario;
    private Long id_destinatario;
    private TarifaEnvioDto tarifaEnvioDto;
    private List<Long> id_pedido_productos;
    private PagoDto pagoDto;

    public PedidoDto() {
    }

    public PedidoDto(Timestamp fechaHora, Timestamp fechaHoraEnvio, Date fechaEntrega, Float total, EstatusEnum estatusEnum, Long id_usuario, Long id_destinatario, TarifaEnvioDto tarifaEnvioDto) {
        this.fechaHora = fechaHora;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.estatusEnum = estatusEnum;
        this.id_usuario = id_usuario;
        this.id_destinatario = id_destinatario;
        this.tarifaEnvioDto = tarifaEnvioDto;
    }

    public PedidoDto(Long id_pedido, Timestamp fechaHora, Timestamp fechaHoraEnvio, Date fechaEntrega, Float total, EstatusEnum estatusEnum, Long id_usuario, Long id_destinatario, TarifaEnvioDto tarifaEnvioDto, List<Long> id_pedido_productos, PagoDto pagoDto) {
        this.id_pedido = id_pedido;
        this.fechaHora = fechaHora;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.estatusEnum = estatusEnum;
        this.id_usuario = id_usuario;
        this.id_destinatario = id_destinatario;
        this.tarifaEnvioDto = tarifaEnvioDto;
        this.id_pedido_productos = id_pedido_productos;
        this.pagoDto = pagoDto;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Timestamp getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Timestamp fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public EstatusEnum getEstatusEnum() {
        return estatusEnum;
    }

    public void setEstatusEnum(EstatusEnum estatusEnum) {
        this.estatusEnum = estatusEnum;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(Long id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public TarifaEnvioDto getTarifaEnvioDto() {
        return tarifaEnvioDto;
    }

    public void setTarifaEnvioDto(TarifaEnvioDto tarifaEnvioDto) {
        this.tarifaEnvioDto = tarifaEnvioDto;
    }

    public List<Long> getId_pedido_productos() {
        return id_pedido_productos;
    }

    public void setId_pedido_productos(List<Long> id_pedido_productos) {
        this.id_pedido_productos = id_pedido_productos;
    }

    public PagoDto getPagoDto() {
        return pagoDto;
    }

    public void setPagoDto(PagoDto pagoDto) {
        this.pagoDto = pagoDto;
    }

    @Override
    public String toString() {
        return "PedidoDto{" + "id_pedido=" + id_pedido + ", fechaHora=" + fechaHora + ", fechaHoraEnvio=" + fechaHoraEnvio + ", fechaEntrega=" + fechaEntrega + ", total=" + total + ", estatusEnum=" + estatusEnum + ", id_usuario=" + id_usuario + ", id_destinatario=" + id_destinatario + ", tarifaEnvioDto=" + tarifaEnvioDto + ", id_pedido_productos=" + id_pedido_productos + ", pagoDto=" + pagoDto + '}';
    }

}
