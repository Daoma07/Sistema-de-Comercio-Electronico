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
@Table(name = "tarifa_envios")
public class TarifaEnvio {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarifa_envio;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String desripcion;

    @Column(name = "costo", nullable = false)
    private Float costo;

    //Relaciones
    @OneToMany(mappedBy = "tarifaEnvio")
    private List<Pedido> pedidos;
}
