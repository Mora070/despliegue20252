package com.jdc.misegundaapi.DTO;

import java.util.Objects;

public class EstudianteDTO {

    private String documento;
    private String nombres;
    private Integer tipodocumento;
    private String telefono;
    private String extensionnumero;
    private Long fkuniversidad;

    public EstudianteDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Integer tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExtensionnumero() {
        return extensionnumero;
    }

    public void setExtensionnumero(String extensionnumero) {
        this.extensionnumero = extensionnumero;
    }

    public Long getFkuniversidad() {
        return fkuniversidad;
    }

    public void setFkuniversidad(Long fkuniversidad) {
        this.fkuniversidad = fkuniversidad;
    }
}
