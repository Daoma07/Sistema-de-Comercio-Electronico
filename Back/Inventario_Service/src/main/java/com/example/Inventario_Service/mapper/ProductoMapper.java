package com.example.Inventario_Service.mapper;

import com.example.Inventario_Service.entity.Carrito;
import com.example.Inventario_Service.entity.PedidoProducto;
import com.example.Inventario_Service.entity.Producto;
import com.example.Inventario_Service.entity.ProductoTalla;
import com.example.Inventario_Service.repository.CarritoRepository;
import com.example.Inventario_Service.repository.PedidoProductoRepository;
import com.mycompany.utilities.dto.ProductoDto;
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

    public ProductoDto mapperToProductoDto(Producto producto) {

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
                categoriaMapper.mapperToCategoriaDto(producto.getCategoria()),
                imagenMapper.mapperListToImagenDto(producto.getImagenes()),
                estiloMapper.mapperToEstiloDto(producto.getEstilo()),
                ProductoTallaMapper.mapperListToProductoTallaDto(producto.getTallas()),
                id_carritos,
                id_pedidos_productos
        );

    }

    public Producto mapperToProducto(ProductoDto productoDto) {
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
                ProductoTallaMapper.mapperListToProductoTalla(productoDto.getProductoTallaDtos()),
                carritoRepository.findAllById(productoDto.getId_carritos()),
                pedidoProductoRepository.findAllById(productoDto.getId_pedidos_productos()));
    }
}
