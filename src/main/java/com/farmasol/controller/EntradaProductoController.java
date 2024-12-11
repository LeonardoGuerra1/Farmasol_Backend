package com.farmasol.controller;

import com.farmasol.model.EntradaProducto;
import com.farmasol.service.EntradaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada_producto")
public class EntradaProductoController {

    @Autowired
    EntradaProductoService entradaProductoService;


    @GetMapping
    public ResponseEntity<?> getEntradaProductos() {
        try {
            List<EntradaProducto> list = entradaProductoService.getEntradaProductos();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            EntradaProducto found = entradaProductoService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró una entrada de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveEntradaProducto(@RequestBody EntradaProducto entradaProducto) {
        try {
            EntradaProducto saved = entradaProductoService.saveEntradaProducto(entradaProducto);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateEntradaProducto(@RequestBody EntradaProducto entradaProducto) {
        try {
            EntradaProducto updated = entradaProductoService.updateEntradaProducto(entradaProducto);
            if (updated == null)
                return new ResponseEntity<>("No se encontró una entrada de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntradaProducto(@PathVariable int id) {
        try {
            boolean deleted = entradaProductoService.deleteEntradaProducto(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró una entrada de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Entrada de producto eliminada correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
