package com.farmasol.service.imp;

import com.farmasol.model.DetalleSalida;
import com.farmasol.repository.DetalleSalidaRepository;
import com.farmasol.service.DetalleSalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleSalidaServiceImp implements DetalleSalidaService {

    @Autowired
    DetalleSalidaRepository detalleSalidaRepository;

    public List<DetalleSalida> getDetallesSalida() {
        return detalleSalidaRepository.findAll();
    }

    public DetalleSalida getPorId(int id) {
        return detalleSalidaRepository.findById(id).orElse(null);
    }

    public DetalleSalida saveDetalleSalida(DetalleSalida detalleSalida) {
        return detalleSalidaRepository.save(detalleSalida);
    }

    public DetalleSalida updateDetalleSalida(DetalleSalida detalleSalida) {
        boolean found = detalleSalidaRepository.existsById(detalleSalida.getIdDetalleSalida());
        if (!found) return null;
        else return detalleSalidaRepository.save(detalleSalida);
    }
}
