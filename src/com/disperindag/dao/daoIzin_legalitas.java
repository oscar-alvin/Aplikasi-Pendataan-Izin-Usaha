/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.izin;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.Date;
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
public class daoIzin_legalitas {
    
    private Connection con = null;

    public daoIzin_legalitas() {
        con = new myConnection().getConnection();
    }
    
    public List<izin> getIzinById(int id){
        List<izin> li = new ArrayList<izin>();
        try {
            String query = "SELECT * FROM "+ MASTER.IZIN_LEGALITAS +" WHERE id_master = '"+ id +"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                izin i = new izin();
                i.setKode_Data(rs.getInt(1));
                i.setId_legalitas(rs.getInt(2));
                i.setJenis_izin(rs.getString(3));
                i.setNomor(rs.getString(4));
                i.setDikeluarkan_oleh(rs.getString(5));
                i.setTgl_berlaku(rs.getDate(6));
                i.setMasa_laku(rs.getInt(7));
                i.setTgl_selesai(rs.getDate(8));
                li.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
    
    public boolean insertIzin(izin i) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO "+ MASTER.IZIN_LEGALITAS +" "
                    + "(ID_MASTER, JENIS_IZIN, NOMOR, DIKELUARKAN_OLEH, TANGGAL_BERLAKU, "
                    + "MASA_LAKU, TANGGAL_SELESAI) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, i.getId_legalitas());
            ps.setString(2, i.getJenis_izin());
            ps.setString(3, i.getNomor());
            ps.setString(4, i.getDikeluarkan_oleh());
            ps.setDate(5, new Date(i.getTgl_berlaku().getTime()) );
            ps.setInt(6, i.getMasa_laku());
            ps.setDate(7, new Date(i.getTgl_selesai().getTime()) );
            if(ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Kode Telah ada");
            }
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean deleteIzin(int kode) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM "+ MASTER.IZIN_LEGALITAS +" WHERE ID_DATA = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, kode);
            if(ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
}
