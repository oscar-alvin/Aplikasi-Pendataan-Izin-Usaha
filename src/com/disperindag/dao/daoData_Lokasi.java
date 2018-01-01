/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_lokasi;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvin
 */
public class daoData_Lokasi {
    private Connection con = null;

    public daoData_Lokasi(Connection con) {
        this.con = con;
    }
    
    public Data_lokasi getLokasi(int id){
        Data_lokasi l = null;
        try {
            String query = "SELECT * FROM "+ MASTER.LOKASI +" WHERE id_master = '" +id+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                l = new Data_lokasi();
                l.setId_lokasi          (rs.getInt(1));
                l.setNama_perusahaan    (rs.getString(2));
                l.setAlamat_perusahaan  (rs.getString(3));
                l.setNama_prop          (rs.getString(4));
                l.setNama_kab           (rs.getString(5));
                l.setNama_kec           (rs.getString(6));
                l.setNama_kel           (rs.getString(7));
                l.setKode_pos           (rs.getString(8));
                l.setNo_tlp             (rs.getString(9));
                l.setFax                (rs.getString(10));
                l.setEmail              (rs.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
    
    public boolean updateLokasi(Data_lokasi l) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.LOKASI +" set nama_perusahaan = (?), "
                    + "alamat_perusahaan = (?), nama_prop_lokasi = (?), nama_kab_lokasi = (?),nama_kec_lokasi = (?),"
                    + "nama_kel_lokasi = (?), kode_pos = (?), no_tlp = (?), fax = (?), "
                    + "email = (?) WHERE id_master = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , l.getNama_perusahaan());
            ps.setString(2 , l.getAlamat_perusahaan());
            ps.setString(3 , l.getNama_prop());
            ps.setString(4 , l.getNama_kab());
            ps.setString(5 , l.getNama_kec());
            ps.setString(6 , l.getNama_kel());
            ps.setString(7 , l.getKode_pos());
            ps.setString(8 , l.getNo_tlp());
            ps.setString(9 , l.getFax());
            ps.setString(10, l.getEmail());
            ps.setInt   (11, l.getId_lokasi());
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
