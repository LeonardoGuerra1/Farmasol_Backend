package com.farmasol.controller;

import com.farmasol.model.DetalleEntrada;
import com.farmasol.model.DetalleSalida;
import com.farmasol.service.DetalleSalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_salida")
public class DetalleSalidaController {

    @Autowired
    DetalleSalidaService detalleSalidaService;

    @GetMapping
    public ResponseEntity<?> getDetallesSalida() {
        try {
            List<DetalleSalida> list = detalleSalidaService.getDetallesSalida();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            DetalleSalida found = detalleSalidaService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró un detalle de salida con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDetalleSalida(@RequestBody DetalleSalida detalleSalida) {
        try {
            DetalleSalida saved = detalleSalidaService.saveDetalleSalida(detalleSalida);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateDetalleSalida(@RequestBody DetalleSalida detalleSalida) {
        try {
            DetalleSalida updated = detalleSalidaService.updateDetalleSalida(detalleSalida);
            if (updated == null)
                return new ResponseEntity<>("No se encontró un detalle de salida con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
