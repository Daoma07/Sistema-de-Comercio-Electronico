package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Carrito;
import com.example.Inventario_Service.entity.PedidoProducto;
import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.repository.CarritoRepository;
import com.example.Inventario_Service.repository.PedidoProductoRepository;
import com.example.Inventario_Service.repository.ProductoTallaRepository;
import com.mycompany.utilities.dto.ProductoDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoMapper {

    @Autowired
    private static ProductoTallaRepository productoTallaRepository;

    @Autowired
    private static CarritoRepository carritoRepository;

    @Autowired
    private static PedidoProductoRepository pedidoProductoRepository;

    public static ProductoDto mapperToProductoDto(Producto producto) {

        List<Long> id_productos_tallas = producto.getTallas().stream().
                map(ProductoTalla::getId_producto_talla).collect(Collectors.toList());

        List<Long> id_carritos = producto.getCarritos().stream().
                map(Carrito::getId_carrito).collect(Collectors.toList());

        List<Long> id_pedidos_productos = producto.getPedidos().stream().
                map(PedidoProducto::getId_pedido_producto).collect(Collectors.toList());

        return new ProductoDto(producto.getId_producto(),
                producto.getNombre(),
                producto.getDescrpcion(),
                producto.getMarca(),
                producto.getMaterial(),
                producto.getColor(),
                producto.getCodigo(),
                producto.getPrecio(),
                CategoriaMapper.mapperToCategoriaDto(producto.getCategoria()),
                ImagenMapper.mapperListToImagenDto(producto.getImagenes()),
                EstiloMapper.mapperToEstiloDto(producto.getEstilo()),
                id_productos_tallas,
                id_carritos,
                id_pedidos_productos
        );

    }

    public static Producto mapperToProducto(ProductoDto productoDto) {
        return new Producto(productoDto.getId_producto(),
                productoDto.getNombre(),
                productoDto.getDescrpcion(),
                productoDto.getMarca(),
                productoDto.getMaterial(),
                productoDto.getColor(),
                productoDto.getCodigo(),
                productoDto.getPrecio(),
                CategoriaMapper.mapperToCategoria(productoDto.getCategoriaDto()),
                ImagenMapper.mapperListToImagen(productoDto.getImagenesDtos()),
                EstiloMapper.mapperToEstilo(productoDto.getEstiloDto()),
                productoTallaRepository.findAllById(productoDto.getId_productos_tallas()),
                carritoRepository.findAllById(productoDto.getId_carritos()),
                pedidoProductoRepository.findAllById(productoDto.getId_pedidos_productos()));
    }
}
