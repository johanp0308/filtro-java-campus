package com.konoha.misionsystem.model;

import java.util.Date;
import java.util.Objects;

public class MisionNinja {
    private Ninja ninja;
    private Mision mision;
    private Date fechaInicio;
    private Date fechaFin;
    

    public MisionNinja() {
    }

    public MisionNinja(Ninja ninja, Mision mision, Date fechaInicio, Date fechaFin) {
        this.ninja = ninja;
        this.mision = mision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Ninja getNinja() {
        return this.ninja;
    }

    public void setNinja(Ninja ninja) {
        this.ninja = ninja;
    }

    public Mision getMision() {
        return this.mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public MisionNinja ninja(Ninja ninja) {
        setNinja(ninja);
        return this;
    }

    public MisionNinja mision(Mision mision) {
        setMision(mision);
        return this;
    }

    public MisionNinja fechaInicio(Date fechaInicio) {
        setFechaInicio(fechaInicio);
        return this;
    }

    public MisionNinja fechaFin(Date fechaFin) {
        setFechaFin(fechaFin);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MisionNinja)) {
            return false;
        }
        MisionNinja misionNinja = (MisionNinja) o;
        return Objects.equals(ninja, misionNinja.ninja) && Objects.equals(mision, misionNinja.mision) && Objects.equals(fechaInicio, misionNinja.fechaInicio) && Objects.equals(fechaFin, misionNinja.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ninja, mision, fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "{" +
            " ninja='" + getNinja() + "'" +
            ", mision='" + getMision() + "'" +
            ", fechaInicio='" + getFechaInicio() + "'" +
            ", fechaFin='" + getFechaFin() + "'" +
            "}";
    }
    
}
