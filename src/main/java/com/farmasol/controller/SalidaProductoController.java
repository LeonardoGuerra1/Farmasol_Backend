package com.farmasol.controller;

import com.farmasol.model.SalidaProducto;
import com.farmasol.model.Usuario;
import com.farmasol.service.SalidaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salida_producto")
public class SalidaProductoController {

    @Autowired
    SalidaProductoService salidaProductoService;

    @GetMapping
    public ResponseEntity<?> getSalidaProductos() {
        try {
            List<SalidaProducto> list = salidaProductoService.getSalidaProductos();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            SalidaProducto found = salidaProductoService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró una salida de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveSalidaProducto(@RequestBody SalidaProducto salidaProducto) {
        try {
            SalidaProducto saved = salidaProductoService.saveSalidaProducto(salidaProducto);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateSalidaProducto(@RequestBody SalidaProducto salidaProducto) {
        try {
            SalidaProducto updated = salidaProductoService.updateSalidaProducto(salidaProducto);
            if (updated == null)
                return new ResponseEntity<>("No se encontró una salida de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalidaProducto(@PathVariable int id) {
        try {
            boolean deleted = salidaProductoService.deleteSalidaProducto(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró una salida de producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Salida de producto eliminada correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
