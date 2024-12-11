package com.farmasol.controller;

import com.farmasol.model.Producto;
import com.farmasol.model.Usuario;
import com.farmasol.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> getProductos() {
        try {
            List<Producto> list = productoService.getProductos();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable int id) {
        try {
            Producto found = productoService.getPorId(id);
            if (found == null)
                return new ResponseEntity<>("No se encontró un producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(found, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
        try {
            Producto saved = productoService.saveProducto(producto);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto) {
        try {
            Producto updated = productoService.updateProducto(producto);
            if (updated == null)
                return new ResponseEntity<>("No se encontró un producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id) {
        try {
            boolean deleted = productoService.deleteProducto(id);
            if (!deleted)
                return new ResponseEntity<>("No se encontró un producto con el id ingresado.", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>("Producto eliminado correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
