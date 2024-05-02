package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Pago;
import com.mycompany.utilities.dto.PagoDto;

public class PagoMapper {

    public static PagoDto mapperToPagoDto(Pago pago) {
        return new PagoDto(pago.getId_pago(),
                pago.getTipoPagoEnum(),
                pago.getEstatusEnum(),
                pago.getFechaHora(),
                pago.getComprobante());
    }

    public static Pago mapperToPago(PagoDto pagoDto) {
        return new Pago(pagoDto.getId_pago(),
                pagoDto.getTipoPagoEnum(),
                pagoDto.getEstatusEnum(),
                pagoDto.getFechaHora(),
                pagoDto.getComprobante());
    }
}
