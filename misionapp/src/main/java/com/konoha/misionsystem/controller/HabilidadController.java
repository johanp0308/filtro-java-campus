package com.konoha.misionsystem.controller;

import java.util.List;

import com.konoha.misionsystem.model.Habilidad;
import com.konoha.misionsystem.repositories.HabilidadDAO;

public class HabilidadController {
    
    private HabilidadDAO habilidadDAO = new HabilidadDAO();

    public List<Habilidad> getAll(){
        return habilidadDAO.getAllHabilidad();
    }

    public void save(Habilidad habilidad){
        habilidadDAO.saveHabilidad(habilidad);
    }
}
