package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.notaventa.NotaVenta;
import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;
import com.laveronica.siscontrol.domain.notaventadetalle.dto.NotaVentaDetalleRegistro;
import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.utils.helpers.ProductoValidacionesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaVentaDetalleService {


    @Autowired
    private ProductoValidacionesHelper productoValidacionesHelper;


    public List<NotaVentaDetalle> registrarNuevoDetalle(List<NotaVentaDetalleRegistro> datos, NotaVenta notaVenta){

        List<NotaVentaDetalle> detalles = datos.stream()
                .map(dn -> {
                    Producto producto = productoValidacionesHelper.encontrarProductoId(dn.productoId());
                    Integer cantidad = dn.cantidad();
                    BigDecimal subTotal = calcularSubTotal(cantidad, producto.getPrecioVenta());
                    return new NotaVentaDetalle(cantidad, producto, notaVenta, subTotal);

                })
                .collect(Collectors.toList());
        return detalles;

    }


    public static BigDecimal calcularSubTotal(Integer cantidad, BigDecimal precioVenta) {
        return precioVenta.multiply(new BigDecimal(cantidad));
    }

    public static BigDecimal calcularTotalGeneral(List<NotaVentaDetalle> detalles ){
        return detalles.stream()
                .map(NotaVentaDetalle::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add );
    }

}
