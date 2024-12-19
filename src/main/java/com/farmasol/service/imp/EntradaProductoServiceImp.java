package com.farmasol.service.imp;

import com.farmasol.model.DetalleEntrada;
import com.farmasol.model.EntradaProducto;
import com.farmasol.repository.DetalleEntradaRepository;
import com.farmasol.repository.EntradaProductoRepository;
import com.farmasol.service.EntradaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaProductoServiceImp implements EntradaProductoService {

    @Autowired
    EntradaProductoRepository entradaProductoRepository;

    @Autowired
    DetalleEntradaRepository detalleEntradaRepository;

    public List<EntradaProducto> getEntradaProductos() {
        return entradaProductoRepository.findAll();
    }

    public EntradaProducto getPorId(int id) {
        return entradaProductoRepository.findById(id).orElse(null);
    }

    public EntradaProducto saveEntradaProducto(EntradaProducto entradaProducto) {
        EntradaProducto saved = entradaProductoRepository.save(entradaProducto);
        saved.getDetalleEntradaList().forEach(i -> {
            i.setEntradaProducto(saved);
            detalleEntradaRepository.save(i);
        });
        return saved;
    }

    public EntradaProducto updateEntradaProducto(EntradaProducto entradaProducto) {
        boolean found = entradaProductoRepository.existsById(entradaProducto.getIdEntrada());
        if (!found) return null;
        else return entradaProductoRepository.save(entradaProducto);
    }

    public boolean deleteEntradaProducto(int id) {
        EntradaProducto found = entradaProductoRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            entradaProductoRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
