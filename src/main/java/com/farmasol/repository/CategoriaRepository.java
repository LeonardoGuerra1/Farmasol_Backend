package com.farmasol.repository;

import com.farmasol.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "update categorias set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
