package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;
import com.laveronica.siscontrol.domain.ordencompradetalle.OrdenCompraDetalle;
import com.laveronica.siscontrol.domain.ordencompradetalle.dto.DatosRegistroOrdenCompraDetalle;
import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.utils.helpers.ProductoValidacionesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenCompraDetalleService {

    @Autowired
    private ProductoValidacionesHelper productoValidacionesHelper;

    public List<OrdenCompraDetalle> registrarListaDetallesOrdenCompra(List<DatosRegistroOrdenCompraDetalle> datos, OrdenCompra ordenCompraNueva) {

        List<OrdenCompraDetalle> detalles = datos.stream()
                .map(
                        dn -> {
                            Producto producto = productoValidacionesHelper.encontrarProductoId(dn.producto());
                            return new OrdenCompraDetalle(dn, producto, ordenCompraNueva);
                        }
                ).collect(Collectors.toList());
        return detalles;
    }

}
