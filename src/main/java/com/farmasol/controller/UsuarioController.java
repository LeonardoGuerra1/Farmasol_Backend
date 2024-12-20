package com.farmasol.controller;

import com.farmasol.model.Usuario;
import com.farmasol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        try {
            List<Usuario> list = usuarioService.getUsuarios();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            Usuario found = usuarioService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró un usuario con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveCategoria(@RequestBody Usuario usuario) {
        try {
            Usuario saved = usuarioService.saveUsuario(usuario);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@RequestBody Usuario usuario) {
        try {
            Usuario updated = usuarioService.updateUsuario(usuario);
            if (updated == null)
                return new ResponseEntity<>("No se encontró un usuario con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable int id) {
        try {
            boolean deleted = usuarioService.deleteUsuario(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró un usuario con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Usuario eliminado correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
