package com.konoha.misionsystem.model;

import com.konoha.misionsystem.model.constants.Rango;
import java.util.Objects;

public class Mision {
    private long misionId;
    private String decripcionMision;
    private Rango rangoMision;
    private double recompensa;


    public Mision() {
    }

    public Mision(long misionId, String decripcionMision, Rango rangoMision, double recompensa) {
        this.misionId = misionId;
        this.decripcionMision = decripcionMision;
        this.rangoMision = rangoMision;
        this.recompensa = recompensa;
    }

    public long getMisionId() {
        return this.misionId;
    }

    public void setMisionId(long misionId) {
        this.misionId = misionId;
    }

    public String getDecripcionMision() {
        return this.decripcionMision;
    }

    public void setDecripcionMision(String decripcionMision) {
        this.decripcionMision = decripcionMision;
    }

    public Rango getRangoMision() {
        return this.rangoMision;
    }

    public void setRangoMision(Rango rangoMision) {
        this.rangoMision = rangoMision;
    }

    public double getRecompensa() {
        return this.recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public Mision misionId(long misionId) {
        setMisionId(misionId);
        return this;
    }

    public Mision decripcionMision(String decripcionMision) {
        setDecripcionMision(decripcionMision);
        return this;
    }

    public Mision rangoMision(Rango rangoMision) {
        setRangoMision(rangoMision);
        return this;
    }

    public Mision recompensa(double recompensa) {
        setRecompensa(recompensa);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mision)) {
            return false;
        }
        Mision mision = (Mision) o;
        return misionId == mision.misionId && Objects.equals(decripcionMision, mision.decripcionMision) && Objects.equals(rangoMision, mision.rangoMision) && recompensa == mision.recompensa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(misionId, decripcionMision, rangoMision, recompensa);
    }

    @Override
    public String toString() {
        return "{" +
            " misionId='" + getMisionId() + "'" +
            ", decripcionMision='" + getDecripcionMision() + "'" +
            ", rangoMision='" + getRangoMision() + "'" +
            ", recompensa='" + getRecompensa() + "'" +
            "}";
    }
    
}