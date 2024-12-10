package com.farmasol.repository;

import com.farmasol.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query(value = "update proveedores set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
