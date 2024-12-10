package com.farmasol.service;

import com.farmasol.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getProductos();
    Producto getPorId(int id);
    Producto saveProducto(Producto producto);
    Producto updateProducto(Producto producto);
    boolean deleteProducto(int id);
}
