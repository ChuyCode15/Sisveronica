package com.laveronica.siscontrol.domain.clientes;

import com.laveronica.siscontrol.domain.clientes.dto.DatosRegistroCliente;
import com.laveronica.siscontrol.domain.contratos.Contrato;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "clientes")
@Entity(name = "cliente")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String rfc;

    private String calle;

    private Integer numero;

    private String fraccionamiento;

    @Column(name = "c_p")
    private String cp;

    private String municipio;

    private String estado;

    @Column(nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();

    public Cliente(@Valid DatosRegistroCliente datos) {
        this.nombre = datos.nombre();
        this.rfc = datos.rfc();
        this.calle = datos.calle();
        this.numero = datos.numero();
        this.fraccionamiento = datos.fraccionamiento();
        this.cp = datos.cp();
        this.municipio = datos.municipio();
        this.estado = datos.estado();
    }
}


