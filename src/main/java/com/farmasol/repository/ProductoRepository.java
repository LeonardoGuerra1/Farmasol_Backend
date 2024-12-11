package com.farmasol.repository;

import com.farmasol.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update productos set estado = 0 where id_producto = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
