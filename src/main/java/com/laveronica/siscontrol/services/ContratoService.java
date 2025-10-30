package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import com.laveronica.siscontrol.domain.contratos.Contrato;
import com.laveronica.siscontrol.repositories.ClienteRepository;
import com.laveronica.siscontrol.domain.contratos.dto.DatosActualizarContrato;
import com.laveronica.siscontrol.domain.contratos.dto.DatosDetalleContrato;
import com.laveronica.siscontrol.domain.contratos.dto.DatosRegistroContrato;
import com.laveronica.siscontrol.infra.exceptions.ex.RecursoExistenteException;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import com.laveronica.siscontrol.repositories.ContratoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Contrato registrarContrato(@Valid DatosRegistroContrato datos) {
        Cliente cliente = clienteRepository.findById(datos.clienteId())
                .orElseThrow(()-> new ResourceNotFoundException("⚠️ Cliente no encontrado !!" + datos.clienteId()));
        if (!contratoRepository.existsByContrato(datos.contrato())){
            Contrato nuevoContrato = new Contrato(datos, cliente);
            contratoRepository.save(nuevoContrato);
            return nuevoContrato;
        }else {
            throw new RecursoExistenteException("⚠️ Error el registro ya existe." + datos.contrato());
        }
    }

    public List<DatosDetalleContrato> listarContratos() {
        List<DatosDetalleContrato> lista = new ArrayList<>(contratoRepository.findAll())
                .stream()
                .filter(Contrato::getActivo)
                .map(DatosDetalleContrato::new)
                .toList();
        return lista;
    }

    public DatosDetalleContrato buscarContratoId(@Valid Long id) {
        return contratoRepository.findById(id)
                .map(DatosDetalleContrato::new)
                .orElseThrow(()-> new ResourceNotFoundException("⚠️ Contrato no encontrado !!"));


    }

    public DatosDetalleContrato actualizarContrato(@Valid Long id, DatosActualizarContrato datos) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("⚠️ Contrato no encontrado !!"));
        if (datos.clienteId() != null ){
            Cliente cliente = clienteRepository.findById(datos.clienteId())
                    .orElseThrow(()-> new ResourceNotFoundException("⚠️ Cliente no encontrado !!" + datos.clienteId()));
            contrato.setCliente(cliente);
        }
        if (datos.partida() != null){
            contrato.setPartida(datos.partida());
        }
        if (datos.fechaInicio() != null){
            contrato.setFechaInicio(datos.fechaInicio());
        }
        if (datos.fechaTermino() != null){
            contrato.setFechaTermino(datos.fechaTermino());
        }
        contratoRepository.save(contrato);
        return new DatosDetalleContrato(contrato);
    }

    public void elimiarContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("⚠️ Contrato no encontrado !!"));
        contrato.setActivo(false);
    }
}
