package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.mycompany.utilities.dto.ProductoTallaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoTallaMapper {

    @Autowired
    private static ProductoRepository productoRepository;

    public static ProductoTallaDto mapperToProductoTallaDto(ProductoTalla productoTalla) {
        return new ProductoTallaDto(productoTalla.getId_producto_talla(),
                productoTalla.getCantidad(),
                TallaMapper.mapperToTallaDto(productoTalla.getTalla()),
                productoTalla.getId_producto_talla());
    }

    public static ProductoTalla mapperToProductoTalla(ProductoTallaDto productoTallaDto) {
        return new ProductoTalla(productoTallaDto.getId_producto_talla(),
                productoTallaDto.getCantidad(),
                TallaMapper.mapperToTalla(productoTallaDto.getTallaDto()),
                productoRepository.findById(productoTallaDto.getId_producto()).orElse(null));
    }

    public static List<ProductoTallaDto> mapperListToProductoTallaDto(List<ProductoTalla> productoTallas) {
        List<ProductoTallaDto> productoTallaDtos = new ArrayList<>();
        for (ProductoTalla productoTalla : productoTallas) {
            productoTallaDtos.add(mapperToProductoTallaDto(productoTalla));
        }
        return productoTallaDtos;
    }

    public static List<ProductoTalla> mapperListToProductoTalla(List<ProductoTallaDto> productoTallaDtos) {
        List<ProductoTalla> productoTalla = new ArrayList<>();
        for (ProductoTallaDto productoTallaDto : productoTallaDtos) {
            productoTalla.add(mapperToProductoTalla(productoTallaDto));
        }
        return productoTalla;
    }

}
