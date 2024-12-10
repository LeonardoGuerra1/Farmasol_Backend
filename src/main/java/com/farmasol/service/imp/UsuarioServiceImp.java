package com.farmasol.service.imp;

import com.farmasol.model.Usuario;
import com.farmasol.repository.UsuarioRepository;
import com.farmasol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        boolean found = usuarioRepository.existsById(usuario.getIdUsuario());
        if (!found) return null;
        else return usuarioRepository.save(usuario);
    }

    public boolean deleteUsuario(int id) {
        Usuario found = usuarioRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            usuarioRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
