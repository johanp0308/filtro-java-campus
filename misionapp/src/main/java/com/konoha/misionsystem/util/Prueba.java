package com.konoha.misionsystem.util;

import java.time.LocalDate;
import java.util.Date;

import com.konoha.misionsystem.model.Mision;

public class Prueba implements Runnable{

    private Mision mision;
    private Date fechaFin;
    
    public Prueba (Mision mision, Date fechaFin){
        this.mision = mision;
        this.fechaFin = fechaFin;
    }
    @Override
    public void run() {
        while (!LocalDate.now().equals(fechaFin)) {
            
        }
        
    }
    

}
