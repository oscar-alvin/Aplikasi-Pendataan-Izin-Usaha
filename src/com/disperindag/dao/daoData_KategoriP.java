/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_KagegoriP;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class daoData_KategoriP {
    private Connection con = null;

    public daoData_KategoriP(Connection con) {
        this.con = con;
    }
    public List<Data_KagegoriP> getKategoriBy(int id){
        List<Data_KagegoriP> lk =  new ArrayList<Data_KagegoriP>();
        try {
            con.setAutoCommit(false);
            String query = "SELECT * FROM "+ MASTER.KATEGORI_PERUSAHAAN +" WHERE ID_MASTER = '"+ id +"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Data_KagegoriP kp = new Data_KagegoriP();
                kp.setId_master(rs.getInt(1));
                kp.setId_kategori(rs.getInt(2));
                kp.setNama_perusahaan(rs.getString(3));
                kp.setNo_tdp(rs.getString(4));
                kp.setAlamat(rs.getString(5));
                kp.setKabupaten(rs.getString(6));
                kp.setPropinsi(rs.getString(7));
                kp.setKode_pos(rs.getString(8));
                kp.setNotlp(rs.getString(9));
                kp.setStatusP(rs.getString(10));
                kp.setJenisKegUsaha(rs.getString(11));
                lk.add(kp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public boolean addKategori(Data_KagegoriP dp) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO "+ MASTER.KATEGORI_PERUSAHAAN +" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt   (1, dp.getId_master());
            ps.setInt   (2, dp.getId_kategori());
            ps.setString(3, dp.getNama_perusahaan());
            ps.setString(4, dp.getNo_tdp());
            ps.setString(5, dp.getAlamat());
            ps.setString(6, dp.getKabupaten());
            ps.setString(7, dp.getPropinsi());
            ps.setString(8, dp.getKode_pos());
            ps.setString(9, dp.getNotlp());
            ps.setString(10,dp.getStatusP());
            ps.setString(11,dp.getJenisKegUsaha());
            if(ps.executeUpdate() == 1){
                con.commit();
                flag = true;
            }
        } catch (Exception e) {
            con.rollback();
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Kode Telah ada");
            }
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean updateKategori(Data_KagegoriP dp) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.KATEGORI_PERUSAHAAN +" SET NAMA_PERUSAHAAN = (?),"
                    + "NO_TDP = (?), ALAMAT_PERUSAHAAN = (?), KABUPATEN = (?), PROPINSI = (?),"
                    + " KODE_POS = (?), NO_TLP = (?), STATUS_PERUSAHAAN = (?), "
                    + "JENIS_KEGUSAHA = (?) WHERE ID_KATEGORI = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dp.getNama_perusahaan());
            ps.setString(2, dp.getNo_tdp());
            ps.setString(3, dp.getAlamat());
            ps.setString(4, dp.getKabupaten());
            ps.setString(5, dp.getPropinsi());
            ps.setString(6, dp.getKode_pos());
            ps.setString(7, dp.getNotlp());
            ps.setString(8, dp.getStatusP());
            ps.setString(9, dp.getJenisKegUsaha());
            ps.setInt   (10,dp.getId_kategori());
            if(ps.executeUpdate() == 1){
                con.commit();
                flag = true;
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean deleteKategori(int id) throws SQLException{
        boolean flag = true;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM "+ MASTER.KATEGORI_PERUSAHAAN +" WHERE ID_KATEGORI = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if(ps.executeUpdate() == 1){
                con.commit();
                flag = true;
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
}
