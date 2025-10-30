package com.laveronica.siscontrol.domain.dias;

import com.laveronica.siscontrol.domain.valores.DiaSemana;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "dias")
@Entity(name = "Dia")

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private LocalDate fecha; // Mapea a DATE en SQL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "dia_semana")
    private DiaSemana diaSemana; // Asumiendo que esta es tu clase enum

    @Column(name = "total_venta_diaria", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalVentaDiaria = BigDecimal.ZERO; // Inicializado a 0.00

    @Column(nullable = false)
    private Boolean activo = true; // Inicializado a TRUE por defecto

    public Dia(LocalDate fecha, DiaSemana diaSemana) {
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.totalVentaDiaria = BigDecimal.ZERO;
        this.activo = true;
    }
}