package com.farmasol.service.imp;

import com.farmasol.model.Usuario;
import com.farmasol.repository.UsuarioRepository;
import com.farmasol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    
    public UsuarioServiceImp() {
    	this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
     	String encoderPassword = this.passwordEncoder.encode(usuario.getContrasena());
    	usuario.setContrasena(encoderPassword);
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
            usuarioRepository.safeDeleteUsuario(id);
            return true;
        }
    }
}
