package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.PedidoProducto;
import com.mycompany.utilities.dto.PedidoProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProductoMapper {

    @Autowired
    private ProductoMapper productoMapper;

    public PedidoProductoDto mapperToPedidoProductoDto(PedidoProducto pedidoProducto) {
        return new PedidoProductoDto(pedidoProducto.getId_pedido_producto(),
                pedidoProducto.getCantidad(),
                pedidoProducto.getImporte(),
                pedidoProducto.getPrecioUnidad(),
                PedidoMapper.mapperToPedidoDto(pedidoProducto.getPedido()),
                productoMapper.mapperToProductoDto(pedidoProducto.getProducto()));
    }

    public PedidoProducto mapperToPedidoProducto(PedidoProductoDto pedidoProductoDto) {
        return new PedidoProducto(pedidoProductoDto.getId_pedido_producto(),
                pedidoProductoDto.getCantidad(),
                pedidoProductoDto.getImporte(),
                pedidoProductoDto.getPrecioUnidad(),
                PedidoMapper.mapperToPedido(pedidoProductoDto.getPedido()),
                productoMapper.mapperToProducto(pedidoProductoDto.getProducto())
        );
    }
}
