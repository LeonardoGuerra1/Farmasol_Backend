package com.farmasol.repository;

import com.farmasol.model.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update proveedores set estado = 0 where id_proveedor = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
