package com.example.Inventario_Service.entity;

import com.mycompany.utilities.dto.enums.ColorEnum;
import com.mycompany.utilities.dto.enums.MaterialEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @Column(name = "nombre", nullable = false, length = 150, unique = true)
    private String nombre;

    @Column(name = "descrpcion", nullable = false, length = 600)
    private String descrpcion;

    @Column(name = "marca", nullable = false, length = 150)
    private String marca;

    @Column(name = "material", nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialEnum material;

    @Column(name = "color", nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column(name = "codigo", nullable = false, length = 150, unique = true)
    private String codigo;

    @Column(name = "precio", nullable = false)
    private float precio;

    //Relaciones
    //Relacion con categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    //Relacion con imagen
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;

    //Relacion con estilo
    @ManyToOne
    @JoinColumn(name = "id_estilo")
    private Estilo estilo;

    //Relacion con talla
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoTalla> tallas;

    //Relacion con carrito
    @OneToMany(mappedBy = "producto")
    private List<Carrito> carritos;

    @OneToMany(mappedBy = "producto")
    private List<PedidoProducto> pedidos;

}
