package com.konoha.misionsystem;

import java.sql.SQLException;

import com.konoha.misionsystem.controller.NinjaController;
import com.konoha.misionsystem.model.Ninja;
import com.konoha.misionsystem.model.constants.Rango;



public class Main {
    public static void main(String[] args) throws SQLException {
        NinjaController m = new NinjaController();

        m.save(new Ninja(0,"Pachon",Rango.GENNIN,"Pachonchin"));
    }
}