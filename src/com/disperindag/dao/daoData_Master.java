/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Master;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvin
 */
public class daoData_Master {

    private Connection con = null;
    private static ResultSet result;
    private static PreparedStatement prepare;
    
    public daoData_Master() {
    }
    
    public daoData_Master(Connection con) {
        this.con = con;
    }
    
    public static ResultSet getMaster(Connection con) throws SQLException {
        String query = "SELECT TM.ID_MASTER, TM.NO_TDP, TM.TANGGAL_ENTRY, TM.JENIS_PERMINTAAN,"
                + "TM.NO_PEMBAHARUAN, TM.JENIS_PERUSAHAAN, DP.NAMA_PENGURUS, TL.NAMA_PERUSAHAAN, "
                + "TL.ALAMAT_PERUSAHAAN FROM " + MASTER.PERUSAHAAN + " TM "
                + "LEFT OUTER JOIN " + MASTER.PEMILIK + " DP ON (DP.ID_MASTER = TM.ID_MASTER) "
                + "LEFT OUTER JOIN " + MASTER.LOKASI + " TL ON (TL.ID_MASTER = TM.ID_MASTER)";
        daoData_Master.prepare = con.prepareStatement(query);
        return daoData_Master.prepare.executeQuery();
    }
    
    public static ResultSet getMasterBy(Connection con, String kriteria, String kode) throws SQLException {
        String query = "SELECT TM.ID_MASTER, TM.NO_TDP, TM.TANGGAL_ENTRY, TM.JENIS_PERMINTAAN,"
                + "TM.NO_PEMBAHARUAN, TM.JENIS_PERUSAHAAN, DP.NAMA_PENGURUS, TL.NAMA_PERUSAHAAN, "
                + "TL.ALAMAT_PERUSAHAAN FROM " + MASTER.PERUSAHAAN + " TM "
                + "LEFT OUTER JOIN " + MASTER.PEMILIK + " DP ON (DP.ID_MASTER = TM.ID_MASTER) "
                + "LEFT OUTER JOIN " + MASTER.LOKASI + " TL ON (TL.ID_MASTER = TM.ID_MASTER)"
                + "WHERE "+kriteria+" LIKE '%"+kode+"%'";
        daoData_Master.prepare = con.prepareStatement(query);
        return daoData_Master.prepare.executeQuery();
    }
    
    public static List<Master> getAllMaster(ResultSet rs) throws SQLException {
        final List<Master> lm = new ArrayList<Master>();
        while (rs.next()) {
            Master mk = new Master();
            mk.setId_master(rs.getInt(1));
            mk.setNo_tdp(rs.getString(2));
            mk.setTgl_regis(rs.getDate(3));
            mk.setJenis_regis(rs.getString(4));
            mk.setNo_pembaharuan(rs.getInt(5));
            mk.setJenis_perusahaan(rs.getString(6));
            mk.setNama_pengurus(rs.getString(7));
            mk.setNama_perusahaan(rs.getString(8));
            mk.setAlamat_perusahaan(rs.getString(9));
            lm.add(mk);
        }
        return lm;
    }
    
    public boolean insertMaster(Master mk) throws SQLException {
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO " + MASTER.PERUSAHAAN + " VALUES (?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, mk.getId_master());
            ps.setString(2, mk.getNo_tdp());
            ps.setDate(3, new java.sql.Date((mk.getTgl_regis().getTime())));
            ps.setString(4, mk.getJenis_regis());
            ps.setInt(5, mk.getNo_pembaharuan());
            ps.setString(6, mk.getJenis_perusahaan());
            if (ps.executeUpdate() == 1) {
                
                Statement st = con.createStatement();
                st.addBatch("INSERT INTO " + MASTER.PEMILIK + " (id_master) VALUES ('" + mk.getId_master() + "')");
                st.addBatch("INSERT INTO " + MASTER.LOKASI + " (id_master) VALUES ('" + mk.getId_master() + "')");
                st.addBatch("INSERT INTO " + MASTER.UMUM + " (id_master) VALUES ('" + mk.getId_master() + "')");
                st.addBatch("INSERT INTO " + MASTER.LEGALITAS + " (id_master) VALUES ('" + mk.getId_master() + "')");
                st.addBatch("INSERT INTO " + MASTER.KEGIATAN + " (id_master) VALUES ('" + mk.getId_master() + "')");
                int[] i = st.executeBatch();                
                
                flag = true;
                con.commit();
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
    
    public boolean updateMaster(Master mk) throws SQLException {
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE " + MASTER.PERUSAHAAN + " SET no_tdp = (?), tanggal_entry = (?), "
                    + "jenis_permintaan = (?), no_pembaharuan = (?), JENIS_PERUSAHAAN = (?) "
                    + "WHERE id_master = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mk.getNo_tdp());
            ps.setDate(2, new java.sql.Date((mk.getTgl_regis().getTime())));
            ps.setString(3, mk.getJenis_regis());
            ps.setInt(4, mk.getNo_pembaharuan());
            ps.setString(5, mk.getJenis_perusahaan());
            ps.setInt(6, mk.getId_master());
            if (ps.executeUpdate() == 1) {
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean deleteMaster(int kode) throws SQLException {
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM " + MASTER.PERUSAHAAN + " WHERE id_master = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, kode);
            if (ps.executeUpdate() == 1) {
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
}
