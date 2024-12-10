package com.farmasol.repository;

import com.farmasol.model.SalidaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalidaProductoRepository extends JpaRepository<SalidaProducto, Integer> {

    @Query(value = "update salida_producto set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
