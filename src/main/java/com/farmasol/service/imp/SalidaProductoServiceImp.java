package com.farmasol.service.imp;

import com.farmasol.model.EntradaProducto;
import com.farmasol.model.SalidaProducto;
import com.farmasol.repository.DetalleSalidaRepository;
import com.farmasol.repository.SalidaProductoRepository;
import com.farmasol.service.SalidaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalidaProductoServiceImp implements SalidaProductoService {

    @Autowired
    SalidaProductoRepository salidaProductoRepository;

    @Autowired
    DetalleSalidaRepository detalleSalidaRepository;

    public List<SalidaProducto> getSalidaProductos() {
        return salidaProductoRepository.findAll();
    }

    public SalidaProducto getPorId(int id) {
        return salidaProductoRepository.findById(id).orElse(null);
    }

    public SalidaProducto saveSalidaProducto(SalidaProducto salidaProducto) {
        SalidaProducto saved = salidaProductoRepository.save(salidaProducto);
        saved.getDetalleSalidaList().forEach(i -> {
            i.setSalidaProducto(saved);
            detalleSalidaRepository.save(i);
        });
        return saved;
    }

    public SalidaProducto updateSalidaProducto(SalidaProducto salidaProducto) {
        boolean found = salidaProductoRepository.existsById(salidaProducto.getIdSalida());
        if (!found) return null;
        else return salidaProductoRepository.save(salidaProducto);
    }

    public boolean deleteSalidaProducto(int id) {
        SalidaProducto found = salidaProductoRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            salidaProductoRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
