package com.jdc.misegundaapi.service;

import com.jdc.misegundaapi.entity.UniversidadEntity;

import java.util.List;

public interface IUniversidadService  {

    public List<UniversidadEntity> findAll();
    public UniversidadEntity findById(Long id);
    public UniversidadEntity findByNit(String nit);
    List<UniversidadEntity> findByDescripcionOrPuntuacion(String descripcion, Float puntuacion);
    public List<Object[]> findByAtributes();

    public void save(UniversidadEntity universidad);
    public void delete(Long id);
}
