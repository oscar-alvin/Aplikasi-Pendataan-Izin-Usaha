/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.keg_usaha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvin
 */
public class daoKegUsaha {
    private Connection con = null;
    
    public daoKegUsaha() {
        con = new myConnection().getConnection();
    }
    
    public List<keg_usaha> getAllUsaha(){
        List<keg_usaha> lk = new ArrayList<keg_usaha>();
        try {
            String query = "SELECT * FROM TABEL_SEKTOR ORDER BY URAIAN ASC";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                keg_usaha p = new keg_usaha();
                p.setKS(rs.getInt(1));
                p.setKode_usaha(rs.getString(2));
                p.setNama_usaha(rs.getString(3));
                lk.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public List<keg_usaha> getUsahaBy(String kriteria, String kode){
        List<keg_usaha> lk = new ArrayList<keg_usaha>();
        try {
            String query = "SELECT * FROM TABEL_SEKTOR WHERE "+kriteria+" LIKE '%"+kode+"%'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                keg_usaha p = new keg_usaha();
                p.setKS(rs.getInt(1));
                p.setKode_usaha(rs.getString(2));
                p.setNama_usaha(rs.getString(3));
                lk.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lk;
    }
    
    public boolean insertUsaha(keg_usaha p) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO TABEL_SEKTOR values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt   (1, p.getKS());
            ps.setString(2, p.getKode_usaha());
            ps.setString(3, p.getNama_usaha());
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
        }
        return flag;
    }
    
    public boolean deleteUsaha(String id) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM SEKTOR WHERE KODE = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
        }
        return flag;
    }
}
