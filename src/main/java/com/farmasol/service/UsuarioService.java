package com.farmasol.service;

import com.farmasol.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Usuario getPorId(int id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    boolean deleteUsuario(int id);
}
