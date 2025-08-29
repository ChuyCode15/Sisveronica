package com.laveronica.siscontrol.domain.clientes;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

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

    public Cliente(@Valid DatosRegistroCliente datos){
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


