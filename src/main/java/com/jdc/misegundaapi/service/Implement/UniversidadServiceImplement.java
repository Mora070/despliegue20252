package com.jdc.misegundaapi.service.Implement;

import com.jdc.misegundaapi.entity.UniversidadEntity;
import com.jdc.misegundaapi.repository.UniversidadRepository;
import com.jdc.misegundaapi.service.IUniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServiceImplement implements IUniversidadService {


    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> findAll() {
        return universidadRepository.findAll();
    }

    @Override
    public UniversidadEntity findById(Long id) {
        return universidadRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UniversidadEntity findByNit(String nit) {
        return universidadRepository.findByNit(nit);
    }

    @Override
    public List<UniversidadEntity> findByDescripcionOrPuntuacion(String descripcion, Float puntuacion) {
        return universidadRepository.findByDescripcionOrPuntuacion(descripcion, puntuacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> findByAtributes() {
        return universidadRepository.findByAtributes();
    }

    @Override
    @Transactional
    public void save(UniversidadEntity universidad) {
        universidadRepository.save(universidad);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        universidadRepository.deleteById(id);
    }

}
