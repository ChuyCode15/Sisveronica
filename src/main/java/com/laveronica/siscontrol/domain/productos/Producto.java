package com.laveronica.siscontrol.domain.productos;

import com.laveronica.siscontrol.domain.categoria.Categoria;
import com.laveronica.siscontrol.domain.productos.dto.DatosRegistroProducto;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.domain.valores.UnidadMedida;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table(name = "productos")
@Entity(name = "producto")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Partida partida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidad_medida", nullable = false)
    private UnidadMedida unidadMedida;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(nullable = false)
    private Boolean activo;

    public Producto(@Valid DatosRegistroProducto datos, Partida partida,Categoria categoria) {

        this.id = null;
        this.nombre = datos.nombre();
        this.partida = partida;
        this.categoria = categoria;
        this.unidadMedida = datos.unidadMedida();
        this.precioCompra = datos.precioCompra();
        this.precioVenta = datos.precioVenta();
        this.activo = true;

    }
}


