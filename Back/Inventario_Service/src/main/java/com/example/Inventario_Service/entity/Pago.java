package com.example.Inventario_Service.entity;

import com.mycompany.utilities.dto.enums.EstatusPagoEnum;
import com.mycompany.utilities.dto.enums.TipoPagoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagos")
public class Pago {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    @Column(name = "tipo_pago", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPagoEnum tipoPagoEnum;

    @Column(name = "estatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstatusPagoEnum estatusEnum;

    @Column(name = "fecha_hora")
    private Timestamp fechaHora;

    @Lob
    @Column(nullable = true)
    private byte[] comprobante;
}
