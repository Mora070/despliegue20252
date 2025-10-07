package com.jdc.misegundaapi.repository;

import com.jdc.misegundaapi.entity.UniversidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversidadRepository extends JpaRepository<UniversidadEntity,Long> {

    @Query("SELECT uni FROM UniversidadEntity uni where uni.nit =?1")
    public UniversidadEntity findByNit(String nit);

    @Query("SELECT uni FROM UniversidadEntity uni WHERE uni.descripcion = ?1 OR uni.puntuacion = ?2")
    List<UniversidadEntity> findByDescripcionOrPuntuacion(String descripcion, Float puntuacion);


    @Query("SELECT unitres.nombre, unitres.puntuacion From UniversidadEntity  unitres")
    public List<Object[]> findByAtributes();


}
