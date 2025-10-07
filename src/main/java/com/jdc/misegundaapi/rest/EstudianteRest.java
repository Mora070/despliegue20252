package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.DTO.EstudianteDTO;
import com.jdc.misegundaapi.entity.EstudianteEntity;
import com.jdc.misegundaapi.entity.UniversidadEntity;
import com.jdc.misegundaapi.service.IEstudianteService;
import com.jdc.misegundaapi.service.IUniversidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteRest {

    private IEstudianteService estudianteService;

    public EstudianteRest(IEstudianteService iEstudianteService){
        this.estudianteService = iEstudianteService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<EstudianteEntity>> findALL(){
        return ResponseEntity.ok(estudianteService.findAll());
    }


    @GetMapping("listarby/{id}")
    public ResponseEntity<EstudianteEntity> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(estudianteService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<EstudianteEntity> create (@RequestBody @Validated EstudianteDTO estudianteDTO){
        try {
            EstudianteEntity miestudiante = estudianteService.save(estudianteDTO);
            ResponseEntity.status(200);
            return ResponseEntity.ok(miestudiante);
        }catch (Exception e){
            System.out.printf("El error es " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
