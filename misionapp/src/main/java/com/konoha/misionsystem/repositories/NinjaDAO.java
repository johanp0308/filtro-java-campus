package com.konoha.misionsystem.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.konoha.misionsystem.controller.HabilidadController;
import com.konoha.misionsystem.model.Ninja;
import com.konoha.misionsystem.model.constants.Rango;
import com.konoha.misionsystem.persistence.BDConector;

public class NinjaDAO {
    
    private HabilidadController habilidadController = new HabilidadController();
    
    private String inset_query = "INSERT INTO tbl_ninja (nombreNinja,rangoNinja,aldea) VALUES (?,?,?);";
    
    public List<Ninja> getAllNinja(){
        List<Ninja> listaNinja = new ArrayList<>();
        Ninja ninja = null; 
        String stm = "SELECT * FROM tbl_ninja;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ninja = (new Ninja()
                        .ninjaId(rs.getInt(1))
                        .nombreNinja(rs.getString(2))
                        .rangoNinja(Rango.estableceRango(rs.getString(3))))
                        .aldea(rs.getString(4));

                listaNinja.add(ninja);
                ninja = null;
            }

            return listaNinja;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ninja getNinjaById(Long id){
        Ninja ninja = null; 
        String stm = "SELECT * FROM tbl_ninja WHERE ninjaId = ?;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ninja = (new Ninja()
                        .ninjaId(rs.getInt(1))
                        .nombreNinja(rs.getString(2))
                        .rangoNinja(Rango.estableceRango(rs.getString(3))))
                        .aldea(rs.getString(4));
            }

            return ninja;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveNinja(Ninja ninja){
    try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(inset_query)) {
        ps.setString(1, ninja.getNombreNinja());
        ps.setString(2, ninja.getRangoNinja().getRango());
        ps.setString(3, ninja.getAldea());
        
        ps.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

}
