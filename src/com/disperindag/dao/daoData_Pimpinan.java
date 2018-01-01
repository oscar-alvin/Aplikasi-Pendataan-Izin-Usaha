/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_pimpinan;
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
 * @author Alvin
 */
public class daoData_Pimpinan {
    private Connection con = null;

    public daoData_Pimpinan(Connection con) {
        this.con = con;
    }
    
    public List<Data_pimpinan> getPimpinanById(int id){
        List<Data_pimpinan> ldp = new ArrayList<Data_pimpinan>();
        try {
            String query = "SELECT * FROM "+ MASTER.PIMPINAN + " WHERE ID_MASTER = '"+id+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Data_pimpinan dp = new Data_pimpinan();
                dp.setId_master(rs.getInt(1));
                dp.setId_pimpinan(rs.getInt(2));
                dp.setKedudukan(rs.getString(3));
                dp.setNama_lengkap(rs.getString(4));
                dp.setAlamat(rs.getString(5));
                dp.setKode_pos(rs.getString(6));
                dp.setNo_tlp(rs.getString(7));
                dp.setKewarganegaraan(rs.getString(8));
                dp.setPengurus(rs.getInt(9));
                dp.setPengawas(rs.getInt(10));
                dp.setDirektur(rs.getInt(11));
                dp.setKomisaris(rs.getInt(12));
                dp.setSa(rs.getInt(13));
                dp.setSp(rs.getInt(14));
                dp.setSabaru(rs.getInt(15));
                dp.setSpbaru(rs.getInt(16));
                dp.setJmlSaham(rs.getInt(17));
                dp.setJmlModal(rs.getDouble(18));
                ldp.add(dp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ldp;
    }
    
    public Data_pimpinan getPimpinan(int kode){
        Data_pimpinan dp = null;
        try {
            String query = "SELECT * FROM "+ MASTER.PIMPINAN +" WHERE id_master = '"+kode+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dp = new Data_pimpinan();
                dp.setId_master(rs.getInt(1));
                dp.setId_pimpinan(rs.getInt(2));
                dp.setKedudukan(rs.getString(3));
                dp.setNama_lengkap(rs.getString(4));
                dp.setAlamat(rs.getString(5));
                dp.setKode_pos(rs.getString(6));
                dp.setNo_tlp(rs.getString(7));
                dp.setKewarganegaraan(rs.getString(8));
                dp.setPengurus(rs.getInt(9));
                dp.setPengawas(rs.getInt(10));
                dp.setDirektur(rs.getInt(11));
                dp.setKomisaris(rs.getInt(12));
                dp.setSa(rs.getInt(13));
                dp.setSp(rs.getInt(14));
                dp.setSabaru(rs.getInt(15));
                dp.setSpbaru(rs.getInt(16));
                dp.setJmlSaham(rs.getInt(17));
                dp.setJmlModal(rs.getDouble(18));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dp;
    }
    
    public boolean insertPimpinan(Data_pimpinan dp) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO "+ MASTER.PIMPINAN +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt   (1, dp.getId_master());
            ps.setInt   (2, dp.getId_pimpinan());
            ps.setString(3, dp.getKedudukan());
            ps.setString(4, dp.getNama_lengkap());
            ps.setString(5, dp.getAlamat());
            ps.setString(6, dp.getKode_pos());
            ps.setString(7, dp.getNo_tlp());
            ps.setString(8, dp.getKewarganegaraan());
            ps.setInt   (9, dp.getPengurus());
            ps.setInt   (10,dp.getPengawas());
            ps.setInt   (11, dp.getDirektur());
            ps.setInt   (12, dp.getKomisaris());
            ps.setInt   (13, dp.getSa());
            ps.setInt   (14, dp.getSp());
            ps.setInt   (15, dp.getSabaru());
            ps.setInt   (16, dp.getSpbaru());
            ps.setInt   (17, dp.getJmlSaham());
            ps.setDouble(18, dp.getJmlModal());
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
    
    public boolean updatePimpinan(Data_pimpinan dp) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.PIMPINAN +" SET KEDUDUKAN = (?),"
                    + " NAMA_LENGKAP = (?), ALAMAT_PIMPINAN = (?), KODE_POS_PIMPINAN = (?), "
                    + "NO_TLP_PIMPINAN = (?), KEWARGANEGARAAN = (?), J_PENGURUS = (?), "
                    + "J_PENGAWAS = (?), J_DIRUT = (?), J_KOMISARIS = (?), J_SA = (?), "
                    + "J_SP = (?), J_SABaru = (?), J_SPBaru = (?), J_saham = (?),"
                    + " J_Modal = (?) WHERE ID_PIMPINAN = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dp.getKedudukan());
            ps.setString(2, dp.getNama_lengkap());
            ps.setString(3, dp.getAlamat());
            ps.setString(4, dp.getKode_pos());
            ps.setString(5, dp.getNo_tlp());
            ps.setString(6, dp.getKewarganegaraan());
            ps.setInt   (7, dp.getPengurus());
            ps.setInt   (8, dp.getPengawas());
            ps.setInt   (9, dp.getDirektur());
            ps.setInt   (10,dp.getKomisaris());
            ps.setInt   (11,dp.getSa());
            ps.setInt   (12,dp.getSp());
            ps.setInt   (13,dp.getSabaru());
            ps.setInt   (14,dp.getSpbaru());
            ps.setInt   (15,dp.getJmlSaham());
            ps.setDouble(16,dp.getJmlModal());
            ps.setInt   (17,dp.getId_pimpinan());
            
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
    
    public boolean deletePimpinan(int id) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM "+ MASTER.PIMPINAN +" WHERE ID_PIMPINAN = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
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
