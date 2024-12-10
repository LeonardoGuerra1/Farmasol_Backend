package com.farmasol.service;

import com.farmasol.model.DetalleSalida;

import java.util.List;

public interface DetalleSalidaService {

    List<DetalleSalida> getDetallesSalida();
    DetalleSalida getPorId(int id);
    DetalleSalida saveDetalleSalida(DetalleSalida detalleSalida);
    DetalleSalida updateDetalleSalida(DetalleSalida detalleSalida);
}
