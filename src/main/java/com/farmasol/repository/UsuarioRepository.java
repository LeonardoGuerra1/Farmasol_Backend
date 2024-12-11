package com.farmasol.repository;

import com.farmasol.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update usuarios set estado = 0 where id_usuario = ?1", nativeQuery = true)
    void safeDeleteUsuario(int id);
}
