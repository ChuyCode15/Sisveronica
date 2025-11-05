package com.laveronica.siscontrol.domain.notaventa;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosRegistroNota;
import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;
import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "nota_ventas")
@Entity(name = "nota_venta")

@Getter
@Setter
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

    public void agregarDetalles(NotaVentaDetalle detalle) {
        detalles.add(detalle);
        detalle.setNotaVenta(this);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_id", nullable = false)
    private Dia dia;

    @Column(name = "total_general", nullable = false)
    private BigDecimal totalGeneral;

    private Boolean activo;

    public NotaVenta(Cliente cliente, Partida partida, Dia dia) {
        this.id = null;
        this.fecha = LocalDateTime.now();
        this.cliente = cliente;
        this.partida = partida;
        this.detalles = new ArrayList<>();
        this.dia = dia;
        this.totalGeneral = BigDecimal.ZERO;
        this.activo = true;

    }

}


