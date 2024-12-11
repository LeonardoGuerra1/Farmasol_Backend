package com.farmasol.controller;

import com.farmasol.model.Proveedor;
import com.farmasol.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<?> getProveedores() {
        try {
            List<Proveedor> list = proveedorService.getProveedores();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            Proveedor found = proveedorService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró un proveedor con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor saved = proveedorService.saveProveedor(proveedor);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProveedor(@RequestBody Proveedor proveedor) {
        try {
            Proveedor updated = proveedorService.updateProveedor(proveedor);
            if (updated == null)
                return new ResponseEntity<>("No se encontró un proveedor con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable int id) {
        try {
            boolean deleted = proveedorService.deleteProveedor(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró un proveedor con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Proveedor eliminado correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
