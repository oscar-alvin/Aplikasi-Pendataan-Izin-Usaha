/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_pemilik;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TOSHIBA
 */
public class daoData_pemilik {
    private Connection con = null;

    public daoData_pemilik(Connection con) {
        this.con = con;
    }
    
    public Data_pemilik getPemilik(int id){
        Data_pemilik p = null;
        try {
            String query = "SELECT * FROM "+ MASTER.PEMILIK +" WHERE id_master = '" + id +"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                p = new Data_pemilik();
                p.setId_pemilik(rs.getInt(1));
                p.setNama_pemilik(rs.getString(2));
                p.setTempat_lahir(rs.getString(3));
                p.setTanggal_lahir(rs.getDate(4));
                p.setAlamat_rumah(rs.getString(5));
                p.setNama_prop(rs.getString(6));
                p.setNama_kab(rs.getString(7));
                p.setNama_kec(rs.getString(8));
                p.setNama_kel(rs.getString(9));
                p.setNo_tlp(rs.getString(10));
                p.setNo_ktp(rs.getString(11));
                p.setKewarganegaraan(rs.getString(12));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    
     public boolean updatePemilik(Data_pemilik p) throws SQLException{
        boolean flag = false;
        java.sql.Date tglLahir = null;
        
        if(p.getTanggal_lahir() != null){
            tglLahir = new Date(p.getTanggal_lahir().getTime());
        }
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.PEMILIK +" SET nama_pengurus = (?), tempat_lahir = (?), tanggal_lahir = (?), "
                    + "alamat_rumah = (?), nama_prop_pemilik = (?), nama_kab_pemilik = (?), nama_kec_pemilik = (?), "
                    + "nama_kel_pemilik = (?), no_tlp_pemilik = (?), no_identitas = (?), wn = (?)"
                    + "WHERE id_master = (?)"; 
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , p.getNama_pemilik());
            ps.setString(2 , p.getTempat_lahir());
            ps.setDate  (3 , tglLahir );
            ps.setString(4 , p.getAlamat_rumah());
            ps.setString(5 , p.getNama_prop());
            ps.setString(6 , p.getNama_kab());
            ps.setString(7 , p.getNama_kec());
            ps.setString(8 , p.getNama_kel());
            ps.setString(9 , p.getNo_tlp());
            ps.setString(10, p.getNo_ktp());
            ps.setString(11, p.getKewarganegaraan());
            ps.setInt   (12, p.getId_pemilik());
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
