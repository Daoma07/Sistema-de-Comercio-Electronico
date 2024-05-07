package com.mycompany.utilities.dto;

import java.io.Serializable;

public class PedidoProductoDto implements Serializable {

    private Long id_pedido_producto;
    private int cantidad;
    private Float importe;
    private Float precioUnidad;
    private PedidoDto pedido;
    private ProductoDto producto;

    public PedidoProductoDto() {
    }

    public PedidoProductoDto(int cantidad, Float importe, Float precioUnidad, PedidoDto pedido, ProductoDto producto) {
        this.cantidad = cantidad;
        this.importe = importe;
        this.precioUnidad = precioUnidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    public PedidoProductoDto(Long id_pedido_producto, int cantidad, Float importe, Float precioUnidad, PedidoDto pedido, ProductoDto producto) {
        this.id_pedido_producto = id_pedido_producto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.precioUnidad = precioUnidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Long getId_pedido_producto() {
        return id_pedido_producto;
    }

    public void setId_pedido_producto(Long id_pedido_producto) {
        this.id_pedido_producto = id_pedido_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public PedidoDto getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDto pedido) {
        this.pedido = pedido;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

}
