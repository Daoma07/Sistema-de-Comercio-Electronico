package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.entity.Talla;
import com.example.Inventario_Service.repository.ProductoTallaRepository;
import com.mycompany.utilities.dto.TallaDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TallaMapper {

    @Autowired
    private ProductoTallaRepository productoTallaRepository;

    public TallaDto mapperToTallaDto(Talla talla) {
        List<Long> id_productos_tallas = talla.getProductos().stream().
                map(ProductoTalla::getId_producto_talla).collect(Collectors.toList());

        return new TallaDto(talla.getId_talla(),
                talla.getTalla_us(),
                talla.getTalla_mx(),
                id_productos_tallas
        );
    }

    public Talla mapperToTalla(TallaDto tallaDto) {

        if (tallaDto.getId_productos_tallas() == null || tallaDto.getId_productos_tallas().isEmpty()) {
            return new Talla(
                    tallaDto.getId_talla(),
                    tallaDto.getTalla_us(),
                    tallaDto.getTalla_mx(),
                    null
            );
        }
        return new Talla(
                tallaDto.getId_talla(),
                tallaDto.getTalla_us(),
                tallaDto.getTalla_mx(),
                productoTallaRepository.findAllById(tallaDto.getId_productos_tallas())
        );
    }

}
