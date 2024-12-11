package com.farmasol.repository;

import com.farmasol.model.EntradaProducto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EntradaProductoRepository extends JpaRepository<EntradaProducto, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update entrada_producto set estado = 0 where id_entrada = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
