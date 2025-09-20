package com.laveronica.siscontrol.domain.productos;

import com.laveronica.siscontrol.domain.categoria.CategoriaRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Producto registrarProducto(DatosRegistroProducto datos){

        if (!productosRepository.existsByNombre(datos.nombre())){
            var categoria = categoriaRepository.findById(datos.categoriaId())
                    .orElseThrow(()-> new EntityNotFoundException(" ⚠️ Categoria ingresada no existe o no es valida"));
            Producto productoNuevo = new Producto(datos, categoria);
            System.out.println(categoria);
            if (!datos.unidadMedida()==null)
            productosRepository.save(productoNuevo);
            return productoNuevo;
        }else {
            throw new ResourceNotFoundException("⚠️ Error el producto ya se encuentra registrado. ");
        }

    }

}
