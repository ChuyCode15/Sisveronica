package com.laveronica.siscontrol.domain.notaventa;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.detalleventa.PartidaVenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotaVenta {
    private Long id;
    private Cliente cliente;
    private LocalDateTime fecha;
    private List<PartidaVenta> partidas = new ArrayList<>();
    private BigDecimal total;
}
