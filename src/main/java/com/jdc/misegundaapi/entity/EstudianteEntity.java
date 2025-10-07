package com.jdc.misegundaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "estudiantes")
public class EstudianteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "documento")
    private String documento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "tipo_documento")
    private Integer tipodocumento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "extensionnumero")
    private String extensionnumero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkuniversidad", referencedColumnName = "iduniversidad")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UniversidadEntity universidad;



    // ===== Getters y Setters =====

    //GETTER PERSONALIZADO
    @JsonProperty ("fkuniversidad")
    public Long getUniversidadId(){
        return universidad != null ? universidad.getIduniversidad() : null;
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

    //public UniversidadEntity getUniversidad() {
       //return universidad;
    //}

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}
