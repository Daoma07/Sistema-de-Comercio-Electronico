package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Categoria;
import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.repository.CategoriaRepository;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.mycompany.utilities.dto.CategoriaDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaMapper {

    @Autowired
    private static CategoriaRepository categoriaRepository;

    @Autowired
    private static ProductoRepository productoRepository;

    public static CategoriaDto mapperToCategoriaDto(Categoria categoria) {
        List<Long> id_categorias_hijas = categoria.getCategorias_hijas().stream()
                .map(Categoria::getId_categoria)
                .collect(Collectors.toList());

        List<Long> id_productos = categoria.getProductos().stream()
                .map(Producto::getId_producto)
                .collect(Collectors.toList());

        Long id_categoria_padre = null;
        if (categoria.getCategoria_padre() != null) {
            id_categoria_padre = categoria.getCategoria_padre().getId_categoria();
        }

        return new CategoriaDto(categoria.getId_categoria(),
                categoria.getNombre(), id_categorias_hijas,
                id_categoria_padre,
                id_productos
        );
    }

    public static Categoria mapperToCategoria(CategoriaDto categoriaDto) {
        return new Categoria(categoriaDto.getId_categoria(),
                categoriaDto.getNombre(),
                categoriaRepository.findAllById(categoriaDto.getId_categorias_hijas()),
                categoriaRepository.findById(categoriaDto.getId_categoria_padre()).orElse(null),
                productoRepository.findAllById(categoriaDto.getId_productos()));
    }

}
