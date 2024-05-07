package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Carrito;
import com.mycompany.utilities.dto.CarritoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {

    @Autowired
    private ProductoMapper productoMapper;

    public CarritoDto mapeprToCarritoDto(Carrito carrito) {
        return new CarritoDto(carrito.getId_carrito(),
                carrito.getImporte(),
                carrito.getPrecio_unidad(),
                carrito.getCantidad(),
                carrito.getId_usuario(),
                productoMapper.mapperToProductoDto(carrito.getProducto()));
    }

    public Carrito mapperToCarrito(CarritoDto carritoDto) {
        return new Carrito(carritoDto.getId_carrito(),
                carritoDto.getImporte(),
                carritoDto.getPrecio_unidad(),
                carritoDto.getCantidad(),
                carritoDto.getId_usuario(),
                productoMapper.mapperToProducto(carritoDto.getProductoDto()));
    }
}
