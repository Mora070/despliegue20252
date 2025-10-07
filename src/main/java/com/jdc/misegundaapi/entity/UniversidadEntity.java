package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "universidades")
public class UniversidadEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduniversidad")
    private Long iduniversidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nit")
    private String nit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "puntuacion")
    private Float puntuacion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(mappedBy = "universidad")
    private VehiculoEntity vehiculoEntity;

    // ===== Getters y Setters =====



    public Long getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
