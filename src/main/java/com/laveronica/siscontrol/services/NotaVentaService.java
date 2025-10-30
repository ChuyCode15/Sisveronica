package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.domain.notaventa.NotaVenta;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosListarNota;
import com.laveronica.siscontrol.repositories.NotaVentaRepository;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosDetalleNota;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosRegistroNota;
import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.utils.helpers.ClienteValidacionesHelper;
import com.laveronica.siscontrol.utils.helpers.PartidaValidacionesHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class NotaVentaService {

    @Autowired
    private NotaVentaRepository notaVentaRepository;

    @Autowired
    private ClienteValidacionesHelper clienteValidacionesHelper;

    @Autowired
    private PartidaValidacionesHelper partidaValidacionesHelper;

    @Autowired
    private NotaVentaDetalleService notaVentaDetalleService;

    @Autowired
    private DiaService diaService;

    @Transactional
    public DatosDetalleNota registrarNota(DatosRegistroNota datos) {


        Cliente cliente = clienteValidacionesHelper.validaClienteExistaId(datos.clienteId());
        Partida partida = partidaValidacionesHelper.validaPartidaExista(datos.partida());
        Dia dia = diaService.registarOBuscarDia(LocalDate.now());

        NotaVenta notaNueva = new NotaVenta( cliente, partida, dia);

        List<NotaVentaDetalle> detalles = notaVentaDetalleService.registrarNuevoDetalle(datos.detalles(), notaNueva);

        notaNueva.setDetalles(detalles);

        BigDecimal totalGeneral = notaVentaDetalleService.calcularTotalGeneral(detalles);
        notaNueva.setTotalGeneral(totalGeneral);

        notaVentaRepository.save(notaNueva);
        return new DatosDetalleNota(notaNueva);
    };

    public Page<DatosListarNota> listarNotas(Pageable paginacion) {
        return notaVentaRepository.findAllByActivoTrue(paginacion)
                .map(DatosListarNota::new);
    }


}
