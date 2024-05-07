package com.mycompany.utilities.dto;

import com.mycompany.utilities.dto.enums.EstatusPagoEnum;
import com.mycompany.utilities.dto.enums.TipoPagoEnum;
import java.io.Serializable;
import java.sql.Timestamp;

public class PagoDto implements Serializable {

    private Long id_pago;
    private TipoPagoEnum tipoPagoEnum;
    private EstatusPagoEnum estatusEnum;
    private Timestamp fechaHora;
    private byte[] comprobante;

    public PagoDto() {
    }

    public PagoDto(TipoPagoEnum tipoPagoEnum, EstatusPagoEnum estatusEnum, Timestamp fechaHora, byte[] comprobante) {
        this.tipoPagoEnum = tipoPagoEnum;
        this.estatusEnum = estatusEnum;
        this.fechaHora = fechaHora;
        this.comprobante = comprobante;
    }

    public PagoDto(Long id_pago, TipoPagoEnum tipoPagoEnum, EstatusPagoEnum estatusEnum, Timestamp fechaHora, byte[] comprobante) {
        this.id_pago = id_pago;
        this.tipoPagoEnum = tipoPagoEnum;
        this.estatusEnum = estatusEnum;
        this.fechaHora = fechaHora;
        this.comprobante = comprobante;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public TipoPagoEnum getTipoPagoEnum() {
        return tipoPagoEnum;
    }

    public void setTipoPagoEnum(TipoPagoEnum tipoPagoEnum) {
        this.tipoPagoEnum = tipoPagoEnum;
    }

    public EstatusPagoEnum getEstatusEnum() {
        return estatusEnum;
    }

    public void setEstatusEnum(EstatusPagoEnum estatusEnum) {
        this.estatusEnum = estatusEnum;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public byte[] getComprobante() {
        return comprobante;
    }

    public void setComprobante(byte[] comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public String toString() {
        return "PagoDto{" + "id_pago=" + id_pago + ", tipoPagoEnum=" + tipoPagoEnum + ", estatusEnum=" + estatusEnum + ", fechaHora=" + fechaHora + ", comprobante=" + comprobante + '}';
    }
    

}
