package com.jdc.misegundaapi.service;

import com.jdc.misegundaapi.DTO.EstudianteDTO;
import com.jdc.misegundaapi.entity.EstudianteEntity;
import com.jdc.misegundaapi.entity.UniversidadEntity;

import java.util.List;

public interface IEstudianteService {
    public List<EstudianteEntity> findAll();
    public EstudianteEntity findById(String id);
    public EstudianteEntity save(EstudianteDTO estudianteDTO);

}
