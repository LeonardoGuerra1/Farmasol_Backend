package com.farmasol.service;

import com.farmasol.model.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getProveedores();
    Proveedor getPorId(int id);
    Proveedor saveProveedor(Proveedor proveedor);
    Proveedor updateProveedor(Proveedor proveedor);
    boolean deleteProveedor(int id);
}
