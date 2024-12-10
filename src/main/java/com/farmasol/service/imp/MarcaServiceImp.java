package com.farmasol.service.imp;

import com.farmasol.model.Marca;
import com.farmasol.repository.MarcaRepository;
import com.farmasol.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImp implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }

    public Marca getPorId(int id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca updateMarca(Marca marca) {
        boolean found = marcaRepository.existsById(marca.getIdMarca());
        if (!found) return null;
        else return marcaRepository.save(marca);
    }

    public boolean deleteMarca(int id) {
        Marca found = marcaRepository.findById(id).orElse(null);
        if (found == null) return false;
        else {
            marcaRepository.safeDeleteCategoria(id);
            return true;
        }
    }
}
