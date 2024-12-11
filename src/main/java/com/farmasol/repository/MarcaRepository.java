package com.farmasol.repository;

import com.farmasol.model.Marca;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update marcas set estado = 0 where id_marca = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
