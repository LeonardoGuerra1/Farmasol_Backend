package com.farmasol.service;

import com.farmasol.model.EntradaProducto;

import java.util.List;

public interface EntradaProductoService {

    List<EntradaProducto> getEntradaProductos();
    EntradaProducto getPorId(int id);
    EntradaProducto saveEntradaProducto(EntradaProducto entradaProducto);
    EntradaProducto updateEntradaProducto(EntradaProducto entradaProducto);
    boolean deleteEntradaProducto(int id);
}
