package com.farmasol.repository;

import com.farmasol.model.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update categorias set estado = 0 where id_categoria = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
