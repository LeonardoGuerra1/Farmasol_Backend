package com.farmasol.service;

import com.farmasol.model.Categoria;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getCategorias();
    Categoria getPorId(int id);
    Categoria saveCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    boolean deleteCategoria(int id);
}
