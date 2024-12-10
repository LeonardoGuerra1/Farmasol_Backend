package com.farmasol.service.imp;

import com.farmasol.model.DetalleEntrada;
import com.farmasol.repository.DetalleEntradaRepository;
import com.farmasol.service.DetalleEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleEntradaServiceImp implements DetalleEntradaService {

    @Autowired
    DetalleEntradaRepository detalleEntradaRepository;

    public List<DetalleEntrada> getDetallesEntrada() {
        return detalleEntradaRepository.findAll();
    }

    public DetalleEntrada getPorId(int id) {
        return detalleEntradaRepository.findById(id).orElse(null);
    }

    public DetalleEntrada saveDetalleEntrada(DetalleEntrada detalleEntrada) {
        return detalleEntradaRepository.save(detalleEntrada);
    }

    public DetalleEntrada updateDetalleEntrada(DetalleEntrada detalleEntrada) {
        boolean found = detalleEntradaRepository.existsById(detalleEntrada.getIdDetalleEntrada());
        if (!found) return null;
        else return detalleEntradaRepository.save(detalleEntrada);
    }
}
