package com.farmasol.service.imp;

import com.farmasol.model.Producto;
import com.farmasol.repository.ProductoRepository;
import com.farmasol.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto) {
        boolean found = productoRepository.existsById(producto.getIdProducto());
        if (!found) return null;
        else return productoRepository.save(producto);
    }

    public boolean deleteProducto(int id) {
        Producto found = productoRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            productoRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
