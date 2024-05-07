package com.example.Inventario_Service.service.impl;

import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.mapper.ProductoMapper;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.example.Inventario_Service.service.ProductoService;
import com.mycompany.utilities.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ProductoDto createProduct(ProductoDto productoDto) {
        Producto producto = productoMapper.mapperToProducto(productoDto);

        producto = productoRepository.save(producto);
        return productoMapper.mapperToProductoDto(producto);
    }

    @Override
    public ProductoDto readProduct(ProductoDto productoDto) {
        Producto producto = productoMapper.mapperToProducto(productoDto);
        producto = productoRepository.findById(producto.getId_producto()).orElse(null);
        return productoMapper.mapperToProductoDto(producto);
    }

}
