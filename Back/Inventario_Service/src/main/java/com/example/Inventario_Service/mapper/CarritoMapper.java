package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Carrito;
import com.mycompany.utilities.dto.CarritoDto;

public class CarritoMapper {

    public static CarritoDto mapeprToCarritoDto(Carrito carrito) {
        return new CarritoDto(carrito.getId_carrito(),
                carrito.getImporte(),
                carrito.getPrecio_unidad(),
                carrito.getCantidad(),
                carrito.getId_usuario(),
                ProductoMapper.mapperToProductoDto(carrito.getProducto()));
    }

    public static Carrito mapperToCarrito(CarritoDto carritoDto) {
        return new Carrito(carritoDto.getId_carrito(),
                carritoDto.getImporte(),
                carritoDto.getPrecio_unidad(),
                carritoDto.getCantidad(),
                carritoDto.getId_usuario(),
                ProductoMapper.mapperToProducto(carritoDto.getProductoDto()));
    }
}
