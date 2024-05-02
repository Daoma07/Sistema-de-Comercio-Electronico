package com.example.Inventario_Service.entity;

import com.mycompany.utilities.dto.enums.EstatusEnum;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
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
@Table(name = "pedidos")
public class Pedido {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @Column(name = "fecha_hora_pedido")
    private Timestamp fechaHora;

    @Column(name = "fecha_hora_envio")
    private Timestamp fechaHoraEnvio;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "estatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstatusEnum estatusEnum;

    @Column(name = "id_usuario", nullable = false)
    private Long id_usuario;

    @Column(name = "id_destinatario", nullable = false)
    private Long id_destinatario;

    //Relaciones 
    @ManyToOne
    @JoinColumn(name = "id_tarifa_envio")
    private TarifaEnvio tarifaEnvio;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoProducto> productos;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_pago")
    private Pago pago;
}
