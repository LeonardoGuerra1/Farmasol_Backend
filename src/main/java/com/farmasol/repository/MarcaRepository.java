package com.farmasol.repository;

import com.farmasol.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    @Query(value = "update marcas set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
