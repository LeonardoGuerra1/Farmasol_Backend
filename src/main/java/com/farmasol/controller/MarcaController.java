package com.farmasol.controller;

import com.farmasol.model.Marca;
import com.farmasol.model.Usuario;
import com.farmasol.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping
    public ResponseEntity<?> getMarcas() {
        try {
            List<Marca> list = marcaService.getMarcas();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            Marca found = marcaService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró una marca con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveMarca(@RequestBody Marca marca) {
        try {
            Marca saved = marcaService.saveMarca(marca);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateMarca(@RequestBody Marca marca) {
        try {
            Marca updated = marcaService.updateMarca(marca);
            if (updated == null)
                return new ResponseEntity<>("No se encontró una marca con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarca(@PathVariable int id) {
        try {
            boolean deleted = marcaService.deleteMarca(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró una marca con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Marca eliminada correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
