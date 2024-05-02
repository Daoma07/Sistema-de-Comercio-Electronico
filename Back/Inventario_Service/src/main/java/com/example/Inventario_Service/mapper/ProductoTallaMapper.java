package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.ProductoTalla;
import com.mycompany.utilities.dto.ProductoTallaDto;

public class ProductoTallaMapper {

    public static ProductoTallaDto mapperTpProductoTallaDto(ProductoTalla productoTalla) {
        return new ProductoTallaDto(productoTalla.getId_producto_talla(),
                productoTalla.getCantidad(),
                TallaMapper.mapperToTallaDto(productoTalla.getTalla()),
                ProductoMapper.mapperToProductoDto(productoTalla.getProducto()));
    }

    public static ProductoTalla mapperToProductoTalla(ProductoTallaDto productoTallaDto) {
        return new ProductoTalla(productoTallaDto.getId_producto_talla(),
                productoTallaDto.getCantidad(),
                TallaMapper.mapperToTalla(productoTallaDto.getTallaDto()),
                ProductoMapper.mapperToProducto(productoTallaDto.getProductoDto()));
    }

}
