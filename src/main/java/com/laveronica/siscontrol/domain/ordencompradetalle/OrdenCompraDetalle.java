package com.laveronica.siscontrol.domain.ordencompradetalle;

import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;
import com.laveronica.siscontrol.domain.ordencompradetalle.dto.DatosRegistroOrdenCompraDetalle;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "orden_compra_detalles")
@Entity(name = "orden_compra_detalle")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrdenCompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_compra_id", nullable = false)
    private OrdenCompra ordenCompra;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    private Double lunes;

    private Double martes;
    private Double miercoles;
    private Double jueves;
    private Double viernes;
    private Double sabado;
    private Double domingo;

    @Column(nullable = false)
    private boolean activo;

    public OrdenCompraDetalle(DatosRegistroOrdenCompraDetalle datos) {
        this.id = null;
        this.ordenCompra = datos.ordenCompra();
        this.fecha = datos.fecha();
        this.lunes = datos.lunes();
        this.martes = datos.martes();
        this.miercoles = datos.miercoles();
        this.jueves = datos.jueves();
        this.viernes = datos.viernes();
        this.sabado = datos.sabado();
        this.domingo = datos.domingo();
        this.activo = true;
    }

}
