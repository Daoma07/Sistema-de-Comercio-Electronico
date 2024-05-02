package com.example.Inventario_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tallas")
public class Talla {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_talla;

    @Column(name = "talla_us", nullable = false, length = 150, unique = true)
    private String talla_us;

    @Column(name = "talla_mx", nullable = false, length = 150, unique = true)
    private String talla_mx;

    //Relacion con producto
    @OneToMany(mappedBy = "talla")
    private List<ProductoTalla> productos;

}
