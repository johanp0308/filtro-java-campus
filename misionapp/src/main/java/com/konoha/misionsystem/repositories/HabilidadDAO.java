package com.konoha.misionsystem.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.konoha.misionsystem.model.Habilidad;
import com.konoha.misionsystem.persistence.BDConector;

public class HabilidadDAO {

    private String insert_query = "INSERT INTO tbl_habilidad(ninjaId,nombreHabilidad,descripcionHabilidad) VALUES (?,?,?);";

    public List<Habilidad> getAllHabilidad(){;
        List<Habilidad> listHabiliad = new ArrayList<>();
        Habilidad hab = null;
        String stm = "SELECT * FROM tbl_habilidad;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hab = (new Habilidad())
                    .ninjaId((long)rs.getInt("ninjaId"))
                    .nombre(rs.getString("nombreHabilidad"))
                    .descripcion(rs.getString("descripcionHabilidad"));
                
                listHabiliad.add(hab);
                hab = null;
            }
            
            return listHabiliad;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveHabilidad(Habilidad habilidad){
        
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(insert_query)) {
            ps.setLong(1, habilidad.getNinjaId());
            ps.setString(2, habilidad.getNombre());
            ps.setString(3, habilidad.getDescripcion());

            ps.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
