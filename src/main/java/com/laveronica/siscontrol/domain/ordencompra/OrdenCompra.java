package com.laveronica.siscontrol.domain.ordencompra;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.contratos.Contrato;
import com.laveronica.siscontrol.domain.ordencompra.dto.datosRegistroOrdenCompra;
import com.laveronica.siscontrol.domain.ordencompradetalle.OrdenCompraDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orden_Compra")
@Entity(name = "ordenes_Compra")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")

public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Partida partida;

    @Column(name = "fecha_inicio_semana", nullable = false)
    private LocalDate fechaInicioSemana;

    @Column(name = "fecha_fin_semana", nullable = false)
    private LocalDate fechaFinSemana;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompraDetalle> detalles = new ArrayList<>();

    @Column(nullable = false)
    private Boolean activo;

    public OrdenCompra(datosRegistroOrdenCompra datos, Cliente cliente, Contrato contrato, List<OrdenCompraDetalle> detalles){
        this.id = null;
        this.cliente = cliente;
        this.contrato = contrato;
        this.fechaInicioSemana = datos.fechaInicioSemana();
        this.fechaFinSemana = datos.fechaFinSemana();
        this.detalles = detalles;
        this.activo = true;

    }

}
