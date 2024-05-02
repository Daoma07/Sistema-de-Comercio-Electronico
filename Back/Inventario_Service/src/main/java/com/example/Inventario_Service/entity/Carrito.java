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
@Table(name = "carritos")
public class Carrito {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    @Column(name = "importe", nullable = false)
    private float importe;

    @Column(name = "precio_unidad", nullable = false)
    private float precio_unidad;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "id_usuario", nullable = false)
    private Long id_usuario;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
