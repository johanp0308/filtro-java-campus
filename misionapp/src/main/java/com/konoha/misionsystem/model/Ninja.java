package com.konoha.misionsystem.model;

import com.konoha.misionsystem.model.constants.Rango;
import java.util.Objects;

public class Ninja {
    private long ninjaId;
    private String nombreNinja;
    private Rango rangoNinja;
    private String aldea;


    public Ninja() {
    }

    public Ninja(long ninjaId, String nombreNinja, Rango rangoNinja, String aldea) {
        this.ninjaId = ninjaId;
        this.nombreNinja = nombreNinja;
        this.rangoNinja = rangoNinja;
        this.aldea = aldea;
    }

    public long getNinjaId() {
        return this.ninjaId;
    }

    public void setNinjaId(long ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getNombreNinja() {
        return this.nombreNinja;
    }

    public void setNombreNinja(String nombreNinja) {
        this.nombreNinja = nombreNinja;
    }

    public Rango getRangoNinja() {
        return this.rangoNinja;
    }

    public void setRangoNinja(Rango rangoNinja) {
        this.rangoNinja = rangoNinja;
    }

    public String getAldea() {
        return this.aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public Ninja ninjaId(long ninjaId) {
        setNinjaId(ninjaId);
        return this;
    }

    public Ninja nombreNinja(String nombreNinja) {
        setNombreNinja(nombreNinja);
        return this;
    }

    public Ninja rangoNinja(Rango rangoNinja) {
        setRangoNinja(rangoNinja);
        return this;
    }

    public Ninja aldea(String aldea) {
        setAldea(aldea);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ninja)) {
            return false;
        }
        Ninja ninja = (Ninja) o;
        return ninjaId == ninja.ninjaId && Objects.equals(nombreNinja, ninja.nombreNinja) && Objects.equals(rangoNinja, ninja.rangoNinja) && Objects.equals(aldea, ninja.aldea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ninjaId, nombreNinja, rangoNinja, aldea);
    }

    @Override
    public String toString() {
        return "{" +
            " ninjaId='" + getNinjaId() + "'" +
            ", nombreNinja='" + getNombreNinja() + "'" +
            ", rangoNinja='" + getRangoNinja() + "'" +
            ", aldea='" + getAldea() + "'" +
            "}";
    }
    
}
