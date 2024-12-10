package com.farmasol.service;

import com.farmasol.model.Marca;

import java.util.List;

public interface MarcaService {

    List<Marca> getMarcas();
    Marca getPorId(int id);
    Marca saveMarca(Marca marca);
    Marca updateMarca(Marca marca);
    boolean deleteMarca(int id);
}
