package com.farmasol.service;

import com.farmasol.model.SalidaProducto;

import java.util.List;

public interface SalidaProductoService {

    List<SalidaProducto> getSalidaProductos();
    SalidaProducto getPorId(int id);
    SalidaProducto saveSalidaProducto(SalidaProducto salidaProducto);
    SalidaProducto updateSalidaProducto(SalidaProducto salidaProducto);
    boolean deleteSalidaProducto(int id);
}
