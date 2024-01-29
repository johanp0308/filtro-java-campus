package com.konoha.misionsystem.model.constants;

public enum Rango {
    GENNIN("gennin"),
    JOUNIN("jounin"),
    YUUNIN("yuunin");

    private String rango;

    private Rango(String rango){
        this.rango = rango;
    }

    public String getRango(){
        return this.rango;
    }

    public static Rango estableceRango(String str){
        switch (str) {
            case "gennin":
                return GENNIN;
            case "jounin":
                return JOUNIN;
            case "yuunin":
                return YUUNIN;
            default:
                return GENNIN;
        }
    }
}
