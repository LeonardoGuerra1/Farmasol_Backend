package com.farmasol.controller;

import com.farmasol.model.DetalleEntrada;
import com.farmasol.service.DetalleEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_entrada")
public class DetalleEntradaController {

    @Autowired
    DetalleEntradaService detalleEntradaService;

    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        try {
            List<DetalleEntrada> list = detalleEntradaService.getDetallesEntrada();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            DetalleEntrada found = detalleEntradaService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró un detalle de entrada con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDetalleEntrada(@RequestBody DetalleEntrada detalleEntrada) {
        try {
            DetalleEntrada saved = detalleEntradaService.saveDetalleEntrada(detalleEntrada);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateDetalleEntrada(@RequestBody DetalleEntrada detalleEntrada) {
        try {
            DetalleEntrada updated = detalleEntradaService.updateDetalleEntrada(detalleEntrada);
            if (updated == null)
                return new ResponseEntity<>("No se encontró un detalle de entrada con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
