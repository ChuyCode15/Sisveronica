package com.laveronica.siscontrol.domain.dias;

import com.laveronica.siscontrol.domain.valores.DiaSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "dias")
@Entity(name = "dia")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "dia_semana")
    private DiaSemana dia;

    @Column(nullable = false)
    private Boolean activo;

}
