package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Estilo;
import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.mycompany.utilities.dto.EstiloDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class EstiloMapper {

    @Autowired
    private static ProductoRepository productoRepository;

    public static EstiloDto mapperToEstiloDto(Estilo estilo) {
        List<Long> id_productos = estilo.getProductos().stream().
                map(Producto::getId_producto).collect(Collectors.toList());

        return new EstiloDto(estilo.getId_estilo(),
                estilo.getNombre(),
                id_productos);
    }

    public static Estilo mapperToEstilo(EstiloDto estiloDto) {
        return new Estilo(estiloDto.getId_estilo(),
                estiloDto.getNombre(),
                productoRepository.findAllById(estiloDto.getId_productos()));
    }

}
