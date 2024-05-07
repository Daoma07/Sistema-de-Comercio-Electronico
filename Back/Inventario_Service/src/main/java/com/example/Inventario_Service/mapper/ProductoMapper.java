package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Carrito;
import com.example.Inventario_Service.entity.PedidoProducto;
import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.repository.CarritoRepository;
import com.example.Inventario_Service.repository.PedidoProductoRepository;
import com.mycompany.utilities.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private PedidoProductoRepository pedidoProductoRepository;

    @Autowired
    private ImagenMapper imagenMapper;

    @Autowired
    private EstiloMapper estiloMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private ProductoTallaMapper productoTallaMapper;

    public ProductoDto mapperToProductoDto(Producto producto) {
        // Inicializar las listas vacías para evitar NullPointerException
        List<Long> id_productos_tallas = new ArrayList<>();
        List<Long> id_carritos = new ArrayList<>();
        List<Long> id_pedidos_productos = new ArrayList<>();

        // Verificar si las listas no son null antes de operar con ellas
        if (producto.getTallas() != null) {
            id_productos_tallas = producto.getTallas().stream()
                    .map(ProductoTalla::getId_producto_talla)
                    .collect(Collectors.toList());
        }

        if (producto.getCarritos() != null) {
            id_carritos = producto.getCarritos().stream()
                    .map(Carrito::getId_carrito)
                    .collect(Collectors.toList());
        }

        if (producto.getPedidos() != null) {
            id_pedidos_productos = producto.getPedidos().stream()
                    .map(PedidoProducto::getId_pedido_producto)
                    .collect(Collectors.toList());
        }

        return new ProductoDto(
                producto.getId_producto(),
                producto.getNombre(),
                producto.getDescrpcion(),
                producto.getMarca(),
                producto.getMaterial(),
                producto.getColor(),
                producto.getCodigo(),
                producto.getPrecio(),
                categoriaMapper.mapperToCategoriaDto(producto.getCategoria()),
                imagenMapper.mapperListToImagenDto(producto.getImagenes()),
                estiloMapper.mapperToEstiloDto(producto.getEstilo()),
                productoTallaMapper.mapperListToProductoTallaDto(producto.getTallas()),
                id_carritos,
                id_pedidos_productos
        );

    }

    public Producto mapperToProducto(ProductoDto productoDto) {

        if (productoDto.getId_carritos() != null || !productoDto.getId_carritos().isEmpty()) {
            return new Producto(productoDto.getId_producto(),
                    productoDto.getNombre(),
                    productoDto.getDescripcion(),
                    productoDto.getMarca(),
                    productoDto.getMaterial(),
                    productoDto.getColor(),
                    productoDto.getCodigo(),
                    productoDto.getPrecio(),
                    categoriaMapper.mapperToCategoria(productoDto.getCategoriaDto()),
                    imagenMapper.mapperListToImagen(productoDto.getImagenesDtos()),
                    estiloMapper.mapperToEstilo(productoDto.getEstiloDto()),
                    productoTallaMapper.mapperListToProductoTalla(productoDto.getProductoTallaDtos()),
                    carritoRepository.findAllById(productoDto.getId_carritos()),
                    pedidoProductoRepository.findAllById(productoDto.getId_pedidos_productos()));
        }

        return new Producto(productoDto.getId_producto(),
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getMarca(),
                productoDto.getMaterial(),
                productoDto.getColor(),
                productoDto.getCodigo(),
                productoDto.getPrecio(),
                categoriaMapper.mapperToCategoria(productoDto.getCategoriaDto()),
                imagenMapper.mapperListToImagen(productoDto.getImagenesDtos()),
                estiloMapper.mapperToEstilo(productoDto.getEstiloDto()),
                productoTallaMapper.mapperListToProductoTalla(productoDto.getProductoTallaDtos()),
                null,
                null);
    }

}
