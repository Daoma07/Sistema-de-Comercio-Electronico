package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Imagen;
import com.example.Inventario_Service.repository.ProductoRepository;
import com.mycompany.utilities.dto.ImagenDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImagenMapper {

    @Autowired
    private ProductoRepository productoRepository;

    public ImagenDto mapperToImagenDto(Imagen imagen) {
        return new ImagenDto(imagen.getId_imagen(), imagen.getContenido(),
                imagen.getProducto().getId_producto());
    }

    public Imagen mapperToImagen(ImagenDto imagenDto) {
        return new Imagen(imagenDto.getId_imagen(), imagenDto.getContenido(),
                productoRepository.findById(imagenDto.getId_producto()).orElse(null));
    }

    public List<ImagenDto> mapperListToImagenDto(List<Imagen> imagenes) {
        List<ImagenDto> imagenDtos = new ArrayList<>();
        for (Imagen imagen : imagenes) {
            imagenDtos.add(mapperToImagenDto(imagen));
        }
        return imagenDtos;
    }

    public List<Imagen> mapperListToImagen(List<ImagenDto> imagenesDtos) {
        List<Imagen> imagenes = new ArrayList<>();
        for (ImagenDto imagen : imagenesDtos) {
            imagenes.add(mapperToImagen(imagen));
        }
        return imagenes;
    }
}
