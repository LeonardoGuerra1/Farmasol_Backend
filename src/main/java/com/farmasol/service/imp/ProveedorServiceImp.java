package com.farmasol.service.imp;

import com.farmasol.model.Proveedor;
import com.farmasol.repository.ProveedorRepository;
import com.farmasol.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor getPorId(int id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        boolean found = proveedorRepository.existsById(proveedor.getIdProveedor());
        if (!found) return null;
        else return proveedorRepository.save(proveedor);
    }

    public boolean deleteProveedor(int id) {
        Proveedor found = proveedorRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            proveedorRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
