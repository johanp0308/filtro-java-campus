package com.konoha.misionsystem.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.konoha.misionsystem.controller.MisionController;
import com.konoha.misionsystem.controller.NinjaController;
import com.konoha.misionsystem.model.MisionNinja;
import com.konoha.misionsystem.persistence.BDConector;


public class MsionNinjaDAO {
    
    private NinjaController ninjaController = new NinjaController();
    private MisionController muMisionController = new MisionController();

    private String insert_query = "INSERT INTO tbl_mision_ninja (ninjaId,misionId,fechaInicio,fechaFin) VALUES (?,?,?,?);";


    public void asignarMision(Long misionId,Long ninjaId){
        try(PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(insert_query)){
            ps.setLong(1, ninjaId);
            ps.setLong(2, misionId);
            ps.setString(3, LocalDate.now().toString());
            ps.setString(4, null);
            ps.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * No lo hice por que no me acuerdo
     */

    public MisionNinja getById(Long id){
        String stm = "SELECT * FROM tbl_mision_ninja WHERE ninjaId = ?;";
        MisionNinja mn =  null;
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mn = new MisionNinja()
                .ninja(ninjaController.getById(rs.getLong(1)))
                .mision(muMisionController.getById(rs.getLong(2)));
                
            }
            return mn;
        } catch (Exception e) {
            return mn;
        }
    }

    public void finalizarMision(Long id){

    }

}
