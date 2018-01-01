/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_Saham;
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
public class daoData_Saham {
    private Connection con = null;

    public daoData_Saham(Connection con) {
        this.con = con;
    }
    
    public List<Data_Saham> getSahamBy(int id){
        List<Data_Saham> ls = new ArrayList<Data_Saham>();
        try {
            String query = "SELECT * FROM "+ MASTER.SAHAM +" WHERE id_master = '"+ id +"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Data_Saham ds = new Data_Saham();
                ds.setId_master(rs.getInt(1));
                ds.setId_saham(rs.getInt(2));
                ds.setJmlPemegang_saham(rs.getInt(3));
                ds.setNama_lengkap(rs.getString(4));
                ds.setAlamat(rs.getString(5));
                ds.setKodePos(rs.getString(6));
                ds.setNoTlp(rs.getString(7));
                ds.setWn(rs.getString(8));
                ds.setNpwp(rs.getString(9));
                ds.setJumlahSaham(rs.getInt(10));
                ds.setJumlahSetor(rs.getDouble(11));
                ls.add(ds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public boolean addSaham(Data_Saham ds) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO "+ MASTER.SAHAM +" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt   (1, ds.getId_master());
            ps.setInt   (2, ds.getId_saham());
            ps.setInt   (3, ds.getJmlPemegang_saham());
            ps.setString(4, ds.getNama_lengkap());
            ps.setString(5, ds.getAlamat());
            ps.setString(6, ds.getKodePos());
            ps.setString(7, ds.getNoTlp());
            ps.setString(8, ds.getWn());
            ps.setString(9, ds.getNpwp());
            ps.setInt   (10, ds.getJumlahSaham());
            ps.setDouble(11, ds.getJumlahSetor());
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
    
    public boolean UpdateSaham(Data_Saham ds) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.SAHAM +" SET JML_PEMEGANG_SAHAM = (?),"
                    + "NAMA_LENGKAP = (?), ALAMAT_SAHAM = (?), KODE_POS_SAHAM = (?),"
                    + "NO_TLP_SAHAM = (?), WN_SAHAM = (?), NPWP_SAHAM = (?), JUMLAH_SAHAM = (?),"
                    + "JUMLAH_MODAL = (?) WHERE ID_SAHAM = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt   (1, ds.getJmlPemegang_saham());
            ps.setString(2, ds.getNama_lengkap());
            ps.setString(3, ds.getAlamat());
            ps.setString(4, ds.getKodePos());
            ps.setString(5, ds.getNoTlp());
            ps.setString(6, ds.getWn());
            ps.setString(7, ds.getNpwp());
            ps.setInt   (8, ds.getJumlahSaham());
            ps.setDouble(9, ds.getJumlahSetor());
            ps.setInt   (10, ds.getId_saham());
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
    
    public boolean deleteSaham(int kode) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM "+ MASTER.SAHAM +" WHERE ID_SAHAM = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, kode);
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
