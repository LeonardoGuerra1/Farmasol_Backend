package com.farmasol.repository;

import com.farmasol.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "update productos set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
