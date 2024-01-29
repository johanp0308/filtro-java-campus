package com.konoha.misionsystem.model;
import java.util.Objects;

public class Habilidad {
    private Long ninjaId;
    private String nombre;
    private String descripcion;

    public Habilidad() {
    }

    public Habilidad(Long ninjaId, String nombre, String descripcion) {
        this.ninjaId = ninjaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getNinjaId() {
        return this.ninjaId;
    }

    public void setNinjaId(Long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Habilidad ninjaId(Long ninjaId) {
        setNinjaId(ninjaId);
        return this;
    }

    public Habilidad nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Habilidad descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Habilidad)) {
            return false;
        }
        Habilidad habilidad = (Habilidad) o;
        return Objects.equals(ninjaId, habilidad.ninjaId) && Objects.equals(nombre, habilidad.nombre) && Objects.equals(descripcion, habilidad.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ninjaId, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "{" +
            " ninjaId='" + getNinjaId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }

    
}
