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
@Table(name = "producto_talla")
public class ProductoTalla {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto_talla;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    //Relaciones 
    @ManyToOne()
    @JoinColumn(name = "id_talla")
    private Talla talla;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
