package com.konoha.misionsystem.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.konoha.misionsystem.controller.NinjaController;
import com.konoha.misionsystem.model.Mision;
import com.konoha.misionsystem.model.Ninja;
import com.konoha.misionsystem.model.constants.Rango;
import com.konoha.misionsystem.persistence.BDConector;

public class MisionDAO {
    private NinjaController ninjaController = new NinjaController();
    private String insert_query = "INSERT INTO tbl_mision (descripcionMision,rangoMision,recompensaMision) VALUES (?,?,?);";


    public Mision getMisionById(Long id){
        String stm = "SELECT * FROM tbl_mision WHERE misionId = ?;";
        Mision ms = null;
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ms = (new Mision())
                    .misionId(rs.getLong(1))
                    .decripcionMision(rs.getString(2))
                    .rangoMision(Rango.estableceRango(rs.getString(3)))
                    .recompensa(rs.getDouble(4));
            }
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Mision> getAllMision(){
        List<Mision> listMision = new ArrayList<>();
        Mision ms = null;
        String stm = "SELECT * FROM tbl_mision;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ms = (new Mision())
                    .misionId(rs.getLong(1))
                    .decripcionMision(rs.getString(2))
                    .rangoMision(Rango.estableceRango(rs.getString(3)))
                    .recompensa(rs.getDouble(4));
                listMision.add(ms);
                ms = null;
            }
            return listMision;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean validarDisponible(Long misionid){
        String stm = "SELECT * FROM tbl_mision_ninja WHERE misionId = ?;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ps.setLong(1, misionid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarMisionComplete(Long misionId){
        String stm = "SELECT * FROM tbl_mision_ninja WHERE misionId = ?;";
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(stm)) {
            ps.setLong(1, misionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getDate("fechaFin")!=null){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveMision(Mision mision){
        try (PreparedStatement ps = BDConector.MySQLConnection().prepareStatement(insert_query)) {
            ps.setString(1, mision.getDecripcionMision());
            ps.setString(2, mision.getRangoMision().getRango());
            ps.setDouble(3, mision.getRecompensa());
            
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mision> getAllMisionForANinjaDisponibles(Long ninjaid){
        Ninja ninja = ninjaController.getById(ninjaid);
        List<Mision> listMision = getAllMision();

        Stream<Mision> comap = 
            listMision.stream().filter(mision -> mision.getRangoMision().equals(ninja.getRangoNinja()) && validarDisponible(mision.getMisionId()));
        return comap.collect(Collectors.toList());
    }

    public List<Mision> getAllMisionForANinjaComplete(Long ninjaid){
        Ninja ninja = ninjaController.getById(ninjaid);
        List<Mision> listMision = getAllMision();

        Stream<Mision> comap = 
            listMision.stream().filter(mision -> mision.getRangoMision().equals(ninja.getRangoNinja()) && validarMisionComplete(mision.getMisionId()));
        return comap.collect(Collectors.toList());
    }

}
