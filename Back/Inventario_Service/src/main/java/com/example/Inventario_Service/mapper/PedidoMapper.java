package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Pedido;
import com.example.Inventario_Service.entity.PedidoProducto;
import com.example.Inventario_Service.repository.PedidoProductoRepository;
import com.mycompany.utilities.dto.PedidoDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoMapper {

    @Autowired
    private static PedidoProductoRepository pedidoProductoRepository;

    public static PedidoDto mapperToPedidoDto(Pedido pedido) {
        List<Long> id_pedido_productos = pedido.getProductos().stream().
                map(PedidoProducto::getId_pedido_producto).collect(Collectors.toList());

        return new PedidoDto(pedido.getId_pedido(),
                pedido.getFechaHora(),
                pedido.getFechaHoraEnvio(),
                pedido.getFechaEntrega(),
                pedido.getTotal(),
                pedido.getEstatusEnum(),
                pedido.getId_usuario(),
                pedido.getId_destinatario(),
                TarifaEnvioMapper.mapperToEnvioDto(pedido.getTarifaEnvio()),
                id_pedido_productos,
                PagoMapper.mapperToPagoDto(pedido.getPago())
        );
    }

    public static Pedido mapperToPedido(PedidoDto pedidoDto) {
        return new Pedido(pedidoDto.getId_pedido(),
                pedidoDto.getFechaHora(),
                pedidoDto.getFechaHoraEnvio(),
                pedidoDto.getFechaEntrega(),
                pedidoDto.getTotal(),
                pedidoDto.getEstatusEnum(),
                pedidoDto.getId_usuario(),
                pedidoDto.getId_destinatario(),
                TarifaEnvioMapper.mapperToTarifaEnvio(pedidoDto.getTarifaEnvioDto()),
                pedidoProductoRepository.findAllById(pedidoDto.getId_pedido_productos()),
                PagoMapper.mapperToPago(pedidoDto.getPagoDto()));
    }
}
