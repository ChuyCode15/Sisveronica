package com.laveronica.siscontrol.services;


import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.contratos.Contrato;
import com.laveronica.siscontrol.domain.ordencompra.dto.DatosListarOrdenCompra;
import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;
import com.laveronica.siscontrol.domain.ordencompra.dto.DatosDetalleOrdenCompra;
import com.laveronica.siscontrol.domain.ordencompra.dto.DatosRegistroOrdenCompra;
import com.laveronica.siscontrol.domain.ordencompradetalle.OrdenCompraDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.repositories.OrdenCompraRespository;
import com.laveronica.siscontrol.utils.helpers.ClienteValidacionesHelper;
import com.laveronica.siscontrol.utils.helpers.ContratoValidacionesHelper;
import com.laveronica.siscontrol.utils.helpers.OrdenCompraValidacionesHelper;
import com.laveronica.siscontrol.utils.helpers.PartidaValidacionesHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraValidacionesHelper ordenCompraValidacionesHelper;

    @Autowired
    private ClienteValidacionesHelper clienteValidacionesHelper;

    @Autowired
    private ContratoValidacionesHelper contratoValidacionesHelper;

    @Autowired
    private OrdenCompraDetalleService ordenCompraDetalleService;

    @Autowired
    private OrdenCompraRespository ordenCompraRespository;

    @Autowired
    private PartidaValidacionesHelper partidaValidacionesHelper;

    public DatosDetalleOrdenCompra registrarOrdenCompra(@Valid DatosRegistroOrdenCompra datos) {
        Partida partida = partidaValidacionesHelper.validaPartidaExistaString(datos.partida());
        ordenCompraValidacionesHelper.validaOrdenCompraExiste(datos.fechaInicioSemana(), partida);
        Cliente cliente = clienteValidacionesHelper.validaClienteExistaId(datos.cliente_id());
        Contrato contrato = contratoValidacionesHelper.validaContratoExisteId(datos.cliente_id());
        OrdenCompra ordenCompraNueva = new OrdenCompra(datos, cliente, contrato, partida);
        List<OrdenCompraDetalle> detalles = ordenCompraDetalleService.registrarListaDetallesOrdenCompra(datos.detalles(), ordenCompraNueva);
        ordenCompraNueva.setDetalles(detalles);
        ordenCompraRespository.save(ordenCompraNueva);
        return new DatosDetalleOrdenCompra(ordenCompraNueva);
    }

    public Page<DatosListarOrdenCompra> listarOrdenesCompra(Pageable paginacion) {
        return ordenCompraRespository.findByAndActivoTrue(paginacion)
                .map(DatosListarOrdenCompra::new);
    }
}
