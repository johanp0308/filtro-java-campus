package com.konoha.misionsystem.controller;

import java.util.List;

import com.konoha.misionsystem.model.Ninja;
import com.konoha.misionsystem.repositories.NinjaDAO;

public class NinjaController {
    
    private NinjaDAO ninjaDAO = new NinjaDAO();

    public List<Ninja> getAll(){
        return ninjaDAO.getAllNinja();
    }

    public Ninja getById(Long id){
        return ninjaDAO.getNinjaById(id);
    }

    public void save(Ninja ninja){
        ninjaDAO.saveNinja(ninja);
    }
}
