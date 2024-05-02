package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Pedido;
import com.example.Inventario_Service.entity.TarifaEnvio;

import com.example.Inventario_Service.repository.PedidoRepository;
import com.mycompany.utilities.dto.TarifaEnvioDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class TarifaEnvioMapper {

    @Autowired
    private static PedidoRepository pedidoRepository;

    public static TarifaEnvioDto mapperToEnvioDto(TarifaEnvio tarifaEnvio) {
        List<Long> id_pedidos = tarifaEnvio.getPedidos().stream().
                map(Pedido::getId_pedido).collect(Collectors.toList());

        return new TarifaEnvioDto(tarifaEnvio.getId_tarifa_envio(),
                tarifaEnvio.getDesripcion(),
                tarifaEnvio.getCosto(),
                id_pedidos);
    }

    public static TarifaEnvio mapperToTarifaEnvio(TarifaEnvioDto tarifaEnvioDto) {
        return new TarifaEnvio(tarifaEnvioDto.getId_tarifa_envio(),
                tarifaEnvioDto.getDesripcion(),
                tarifaEnvioDto.getCosto(),
                pedidoRepository.findAllById(tarifaEnvioDto.getId_pedidosdto()));
    }
}
