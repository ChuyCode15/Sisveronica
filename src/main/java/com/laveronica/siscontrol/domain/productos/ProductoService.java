package com.laveronica.siscontrol.domain.productos;

import com.laveronica.siscontrol.domain.categoria.Categoria;
import com.laveronica.siscontrol.domain.productos.dto.DatosDetalleProducto;
import com.laveronica.siscontrol.domain.productos.dto.DatosListarProductos;
import com.laveronica.siscontrol.domain.productos.dto.DatosRegistroProducto;
import com.laveronica.siscontrol.domain.productos.helpers.CategoriaValidacionesHelper;
import com.laveronica.siscontrol.domain.productos.validaciones.ValidadorDeProductos;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.domain.valores.helpers.PartidaValidacionesHelper;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private PartidaValidacionesHelper partidaValidacionesHelper;

    @Autowired
    private CategoriaValidacionesHelper categoriaValidacionesHelper;

    @Autowired
    private List<ValidadorDeProductos> validadores;

    @Autowired
    private ProductosRepository productosRepository;

    @Transactional
    public Producto registrarProducto(DatosRegistroProducto datos){

        DatosRegistroProducto datosNormalizados = new DatosRegistroProducto(
                datos.nombre().trim().toLowerCase(),
                datos.partida(),
                datos.categoriaId(),
                datos.unidadMedida(),
                datos.precioCompra(),
                datos.precioVenta()
        );
        validadores.forEach(v -> v.validar(datosNormalizados));
        Partida partida = partidaValidacionesHelper.validaPartidaExista(datosNormalizados.partida());
        Categoria categoria = categoriaValidacionesHelper.validarCategoriaActiva(datosNormalizados.categoriaId());
        var nuevoProducto = new Producto(datosNormalizados, partida, categoria);
        productosRepository.save(nuevoProducto);
        return nuevoProducto;
    }


    public Page<DatosListarProductos> listaProductos(Pageable paguinas) {
        var page = productosRepository.findAllByActivoTrue(paguinas).map(DatosListarProductos::new);
        return page;
    }


    public Page<DatosListarProductos> listaProductosPartida(Pageable paguinas, String partida) {

        Partida partidaEnum = partidaValidacionesHelper.validaPartidaExista(partida);
        var page = productosRepository.findAllByPartidaAndActivoTrue(partidaEnum, paguinas).map(DatosListarProductos::new);
        if (page.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron productos activos para la partida.");
        }
        return page;
    }


    public Page<DatosListarProductos> listaProdictosCategoriaId(Long id, Pageable paguinas) {

        Categoria categoria = categoriaValidacionesHelper.validarCategoriaActiva(id);
        var page = productosRepository.findAllByCategoriaAndActivoTrue(categoria, paguinas).map(DatosListarProductos::new);
        if (page.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron productos activos para la Categoria.");
        }
        return page;
    }


    public DatosDetalleProducto buscarProductoId(Long id) {

        Producto productoEncontrado = productosRepository.findByIdAndActivoTrue(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("El Id introducido no corresponde a ningun producto")
                );
        return new DatosDetalleProducto(productoEncontrado);

    }

    public DatosDetalleProducto buscarProductoNombre(String nombre) {
        Producto productoEncontrado = productosRepository.findByNombreAndActivoTrue(nombre)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("No existe producto en el '"+nombre+"' registrado")
                );
        return new DatosDetalleProducto(productoEncontrado);
    }
}
