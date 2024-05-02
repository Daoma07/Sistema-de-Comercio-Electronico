package com.example.Inventario_Service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(name = "nombre", nullable = false, length = 150, unique = true)
    private String nombre;

    //Relaciones
    @OneToMany(mappedBy = "categoria_padre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias_hijas;

    //Recursividad
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoria_padre;

    //Relacion con Producto
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
