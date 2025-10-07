package com.jdc.misegundaapi.DTO;

import java.util.Objects;

public class SQL1Universidad {

    private String nombre;
    private float puntuacion;

    public SQL1Universidad() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SQL1Universidad that = (SQL1Universidad) o;
        return Float.compare(puntuacion, that.puntuacion) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, puntuacion);
    }

    @Override
    public String toString() {
        return "SQL1Universidad{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
