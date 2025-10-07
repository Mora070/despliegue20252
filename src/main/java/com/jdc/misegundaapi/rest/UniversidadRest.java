package com.jdc.misegundaapi.rest;

import com.jdc.misegundaapi.DTO.SQL1Universidad;
import com.jdc.misegundaapi.entity.UniversidadEntity;
import com.jdc.misegundaapi.service.IUniversidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/universidad")
public class UniversidadRest {

    private IUniversidadService universidadService;

    public UniversidadRest(IUniversidadService iUniversidadService){
        this.universidadService = iUniversidadService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<UniversidadEntity>> findALL(){
        return ResponseEntity.ok(universidadService.findAll());
    }


    @GetMapping("listarby/{id}")
    public ResponseEntity<UniversidadEntity> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(universidadService.findById(id));
    }

    @GetMapping("/listarbyidparam")
    public ResponseEntity<UniversidadEntity>
    findByIdParam(@RequestParam("id")Long id){
        return ResponseEntity.ok(universidadService.findById(id));
    }


    @GetMapping("/listarbynit/{nit}")
    public ResponseEntity<UniversidadEntity> findByNit(@PathVariable("nit") String nit) {
        return ResponseEntity.ok(universidadService.findByNit(nit));
    }



    @GetMapping("/universidades/buscar/{descripcion}/{puntuacion}")
    public ResponseEntity<List<UniversidadEntity>> buscarPorDescripcionOPuntuacion(
            @PathVariable("descripcion") String descripcion,
            @PathVariable("puntuacion") Float puntuacion) {

       return ResponseEntity.ok(universidadService.findByDescripcionOrPuntuacion(descripcion,puntuacion));
    }

    @GetMapping("/sql1")
    public ResponseEntity<List<SQL1Universidad>> findByAtributes(){

        //Recuperar datos del servicio
        List<Object[]> results = universidadService.findByAtributes();

        // Crear una lista para almacenar objetos
        List<SQL1Universidad> consultas = new ArrayList<>();

        for (Object[] record : results) {
            SQL1Universidad sql1Universidad = new SQL1Universidad();
            //Verificar si se tiene datos

            if(record.length >= 2){
                sql1Universidad.setNombre(record[0] != null ? record[0].toString() : null);
                sql1Universidad.setPuntuacion(record[0] != null ? Float.parseFloat(record[1].toString()) : null);
            }
            System.out.println("Datos" + record[0] + " - " + record[1]);
            consultas.add(sql1Universidad);
        }

        return ResponseEntity.ok(consultas);
    }

    @PostMapping("/crear")
    public ResponseEntity<UniversidadEntity> create (@RequestBody @Validated UniversidadEntity universidad){

        try {
            universidadService.save(universidad);
            ResponseEntity.status(200);
            return ResponseEntity.ok(universidad);
        }catch (Exception e){
            System.out.printf("El error es " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("deleteby/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Long id){

        try{
            universidadService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro elimindado: " + id);
        }catch (Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<UniversidadEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated UniversidadEntity universidad) {

        try {
            // Primero buscamos si existe
            UniversidadEntity existente = universidadService.findById(id);
            // Actualizamos los campos (ajusta según tus atributos de UniversidadEntity)
            existente.setNombre(universidad.getNombre());
            existente.setNit(universidad.getNit());
            existente.setDescripcion(universidad.getDescripcion());
            existente.setPuntuacion(universidad.getPuntuacion());
            existente.setDireccion(universidad.getDireccion());
            // Guardamos
            universidadService.save(existente);

            ResponseEntity.status(200);
            return ResponseEntity.ok(existente);

        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
