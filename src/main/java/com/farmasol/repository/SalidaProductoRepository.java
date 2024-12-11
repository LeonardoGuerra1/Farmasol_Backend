package com.farmasol.repository;

import com.farmasol.model.SalidaProducto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalidaProductoRepository extends JpaRepository<SalidaProducto, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update salida_producto set estado = 0 where id_salida = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
