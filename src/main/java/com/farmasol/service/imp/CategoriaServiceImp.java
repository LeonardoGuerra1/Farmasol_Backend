package com.farmasol.service.imp;

import com.farmasol.model.Categoria;
import com.farmasol.repository.CategoriaRepository;
import com.farmasol.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getPorId(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Categoria categoria) {
        boolean found = categoriaRepository.existsById(categoria.getIdCategoria());
        if (!found) return null;
        else return categoriaRepository.save(categoria);
    }

    public boolean deleteCategoria(int id) {
        Categoria found = categoriaRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            categoriaRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
