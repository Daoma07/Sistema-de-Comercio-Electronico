/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inventario_Service.service.impl;

import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.mapper.ProductoMapper;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.example.Inventario_Service.service.ProductoService;
import com.mycompany.utilities.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Daniel
 */
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoDto createProduct(ProductoDto productoDto) {
        Producto producto = ProductoMapper.mapperToProducto(productoDto);
        producto = productoRepository.save(producto);
        return ProductoMapper.mapperToProductoDto(producto);
    }

    @Override
    public ProductoDto readProduct(ProductoDto productoDto) {
        Producto producto = ProductoMapper.mapperToProducto(productoDto);
        producto = productoRepository.findById(producto.getId_producto()).orElse(null);
        return ProductoMapper.mapperToProductoDto(producto);
    }

}
