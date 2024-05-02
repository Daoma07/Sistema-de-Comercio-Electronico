package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.PedidoProducto;
import com.mycompany.utilities.dto.PedidoProductoDto;

public class PedidoProductoMapper {
    
    public static PedidoProductoDto mapperToPedidoProductoDto(PedidoProducto pedidoProducto) {
        return new PedidoProductoDto(pedidoProducto.getId_pedido_producto(),
                pedidoProducto.getCantidad(),
                pedidoProducto.getImporte(),
                pedidoProducto.getPrecioUnidad(),
                PedidoMapper.mapperToPedidoDto(pedidoProducto.getPedido()),
                ProductoMapper.mapperToProductoDto(pedidoProducto.getProducto()));
    }
    
    public static PedidoProducto mapperToPedidoProducto(PedidoProductoDto pedidoProductoDto) {
        return new PedidoProducto(pedidoProductoDto.getId_pedido_producto(),
                pedidoProductoDto.getCantidad(),
                pedidoProductoDto.getImporte(),
                pedidoProductoDto.getPrecioUnidad(),
                PedidoMapper.mapperToPedido(pedidoProductoDto.getPedido()),
                ProductoMapper.mapperToProducto(pedidoProductoDto.getProducto())
        );
    }
}
