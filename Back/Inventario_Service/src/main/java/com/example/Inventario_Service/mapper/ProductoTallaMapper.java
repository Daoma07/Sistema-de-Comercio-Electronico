package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.mycompany.utilities.dto.ProductoTallaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoTallaMapper {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoTallaDto mapperToProductoTallaDto(ProductoTalla productoTalla) {
        return new ProductoTallaDto(productoTalla.getId_producto_talla(),
                productoTalla.getCantidad(),
                TallaMapper.mapperToTallaDto(productoTalla.getTalla()),
                productoTalla.getId_producto_talla());
    }

    public ProductoTalla mapperToProductoTalla(ProductoTallaDto productoTallaDto) {
        Producto producto = null;
        if (productoTallaDto.getId_producto_talla() == null) {
            producto = productoRepository.findById(productoTallaDto.getId_producto()).orElse(null);
        }
        return new ProductoTalla(productoTallaDto.getId_producto_talla(),
                productoTallaDto.getCantidad(),
                TallaMapper.mapperToTalla(productoTallaDto.getTallaDto()),
                producto);
    }

    public List<ProductoTallaDto> mapperListToProductoTallaDto(List<ProductoTalla> productoTallas) {
        List<ProductoTallaDto> productoTallaDtos = new ArrayList<>();
        for (ProductoTalla productoTalla : productoTallas) {
            productoTallaDtos.add(mapperToProductoTallaDto(productoTalla));
        }
        return productoTallaDtos;
    }

    public List<ProductoTalla> mapperListToProductoTalla(List<ProductoTallaDto> productoTallaDtos) {
        List<ProductoTalla> productoTalla = new ArrayList<>();
        for (ProductoTallaDto productoTallaDto : productoTallaDtos) {
            productoTalla.add(mapperToProductoTalla(productoTallaDto));
        }
        return productoTalla;
    }

}
