package com.example.Inventario_Service.service;

import com.mycompany.utilities.dto.ProductoDto;

public interface ProductoService {

    ProductoDto createProduct(ProductoDto productoDto);

    ProductoDto readProduct(ProductoDto productoDto);
}
