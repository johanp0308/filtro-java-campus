package com.konoha.misionsystem.controller;

import java.util.List;

import com.konoha.misionsystem.model.Mision;
import com.konoha.misionsystem.repositories.MisionDAO;

public class MisionController {
    
    private MisionDAO misionDAO = new MisionDAO();

    public Mision getById(Long id){
        return misionDAO.getMisionById(id);
    }

    public List<Mision> getAll(){
        return misionDAO.getAllMision();
    }

    public void save(Mision mision){
        misionDAO.saveMision(mision);
    }

    public void findMsionDisponibles(Long ninjaId){
        misionDAO.getAllMisionForANinjaDisponibles(ninjaId);
    }

    public void findMsionComplete(Long ninjaId){
        misionDAO.getAllMisionForANinjaDisponibles(ninjaId);
    }

}
