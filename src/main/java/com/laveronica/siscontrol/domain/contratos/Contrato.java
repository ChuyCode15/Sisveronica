package com.laveronica.siscontrol.domain.contratos;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table(name = "contratos")
@Entity(name = "contrato")

public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Partida partida;

    private LocalDate fechaInicio;

    private LocalDate fechaTermino;
    private Boolean activo;


    public Contrato(@Valid DatosRegistroContrato datos, Cliente cliente) {


        this.cliente = cliente;
        this.contrato = datos.contrato();
        this.partida = datos.partida();
        this.fechaInicio = datos.fechaInicio();
        this.fechaTermino = datos.fechaTermino();
        this.activo= true;



    }
}
