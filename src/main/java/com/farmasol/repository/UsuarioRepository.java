package com.farmasol.repository;

import com.farmasol.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "update usuarios set estado = 0 where id = ?1", nativeQuery = true)
    void safeDeleteCategoria(int id);
}
