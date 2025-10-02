package com.laveronica.siscontrol.domain.notaventa;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;
import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "notaventas")
@Entity(name = "notaventa")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class NotaVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Partida partida;

    @OneToMany(mappedBy = "notaVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotaVentaDetalle> detalles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_id",nullable = false)
    private Dia dia;

    @Column(name = "total_general", nullable = false)
    private BigDecimal totalGeneral;

    @Column(nullable = false)
    private Boolean activo;

}


