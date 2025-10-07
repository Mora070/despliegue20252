package com.jdc.misegundaapi.service.Implement;

import com.jdc.misegundaapi.DTO.EstudianteDTO;
import com.jdc.misegundaapi.entity.EstudianteEntity;
import com.jdc.misegundaapi.entity.UniversidadEntity;
import com.jdc.misegundaapi.repository.EstudianteRepository;
import com.jdc.misegundaapi.repository.UniversidadRepository;
import com.jdc.misegundaapi.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteServiceImplement implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteEntity> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteEntity findById(String id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public EstudianteEntity save(EstudianteDTO estudianteDTO) {
        UniversidadEntity unifk = universidadRepository.findById(estudianteDTO.getFkuniversidad()).orElse(null);

        EstudianteEntity estudiantesave = new EstudianteEntity();
        estudiantesave.setDocumento(estudianteDTO.getDocumento());
        estudiantesave.setNombres(estudianteDTO.getNombres());
        estudiantesave.setTelefono(estudianteDTO.getTelefono());
        estudiantesave.setTipodocumento(estudianteDTO.getTipodocumento());
        estudiantesave.setExtensionnumero(estudianteDTO.getExtensionnumero());
        estudiantesave.setUniversidad(unifk);

        return estudianteRepository.save(estudiantesave);
    }


}
