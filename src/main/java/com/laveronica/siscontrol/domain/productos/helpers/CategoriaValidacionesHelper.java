package com.laveronica.siscontrol.domain.productos.helpers;

import com.laveronica.siscontrol.domain.categoria.Categoria;
import com.laveronica.siscontrol.domain.categoria.CategoriaRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValidacionesHelper {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria validarCategoriaActiva(Long id){

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La categoría ingresada (ID: " + id + ") no existe."));
        if (!categoria.getActivo()){
            throw new ResourceNotFoundException("⚠️ La categoría: " + categoria.getNombre() + " se encuentra inactiva o eliminada.");
        }
        return categoria;
    }
}
