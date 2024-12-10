package com.farmasol.service;

import com.farmasol.model.DetalleEntrada;

import java.util.List;

public interface DetalleEntradaService {

    List<DetalleEntrada> getDetallesEntrada();
    DetalleEntrada getPorId(int id);
    DetalleEntrada saveDetalleEntrada(DetalleEntrada detalleEntrada);
    DetalleEntrada updateDetalleEntrada(DetalleEntrada detalleEntrada);

}
