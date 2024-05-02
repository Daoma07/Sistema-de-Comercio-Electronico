package com.example.Inventario_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_producto")
public class PedidoProducto {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido_producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "importe", nullable = false)
    private Float importe;

    @Column(name = "precioUnidad", nullable = false)
    private Float precioUnidad;

    //Relaciones
    @ManyToOne()
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
