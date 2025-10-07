package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "vehiculos")
public class VehiculoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private Long idvehiculo;

    @Column(name = "placa", unique = true)
    private String placa;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "fkmiuniversidad")
    @JsonIgnore
    private UniversidadEntity universidad;

    //Get Personalizado
    @JsonProperty("fkmiuniversidad")
    public Long getUniversidadId(){
        return universidad != null ? universidad.getIduniversidad() : null;
    }


    public Long getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //public UniversidadEntity getUniversidad() {
       // return universidad;
   // }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}
