/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_legalitas;
import com.disperindag.sql.MASTER;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvin
 */
public class daoData_Legalitas {
     private Connection con = null;

    public daoData_Legalitas(Connection con) {
        this.con = con;
    }
    
    public Data_legalitas getLegalitas(int id){
        Data_legalitas l = null;
        try {
            String query = "SELECT * FROM "+ MASTER.LEGALITAS +" WHERE ID_MASTER = '"+id+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                l = new Data_legalitas();
                l.setId_legalitas(rs.getInt(1));
                l.setNo_akta_berdiri(rs.getString(2));
                l.setTgl_akta_berdiri(rs.getDate(3));
                l.setNama_notaris_berdiri(rs.getString(4));
                l.setAlamat(rs.getString(5));
                l.setNotlp(rs.getString(6));
                l.setNo_akta_perubahan1(rs.getString(7));
                l.setTgl_akta_perubahan1(rs.getDate(8));
                l.setNama_notaris_perubahan(rs.getString(9));
                l.setNo_akta_perubahan2(rs.getString(10));
                l.setTgl_akta_perubahan2(rs.getDate(11));
                l.setNo_perse7(rs.getString(12));
                l.setTgl_perse7(rs.getDate(13));
                l.setNo_pengesahan(rs.getString(14));
                l.setTglPengesahan(rs.getDate(15));
                l.setNo_laporan(rs.getString(16));
                l.setTglLaporan(rs.getDate(17));
                l.setNo_pemberitahuan(rs.getString(18));
                l.setTglPemberitahuan(rs.getDate(19));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        return l;
    }
    
    public boolean updateLegalitas(Data_legalitas l) throws SQLException{
        boolean flag = false;
        
        Date berdiri = null;
        Date perubahan1 = null;
        Date perubahan2 = null;
        Date perse7an = null;
        Date pengesahan = null;
        Date laporan = null;
        Date pemberitahuan = null;
        
        if(l.getTgl_akta_berdiri() != null){
            berdiri = new Date(l.getTgl_akta_berdiri().getTime());
        }
        if(l.getTgl_akta_perubahan1() != null){
            perubahan1 = new Date(l.getTgl_akta_perubahan1().getTime());
        }
        if(l.getTgl_akta_perubahan2() != null){
            perubahan2 = new Date(l.getTgl_akta_perubahan2().getTime());
        }
        if(l.getTgl_perse7() != null){
            perse7an = new Date(l.getTgl_perse7().getTime());
        }
        if(l.getTglPengesahan() != null){
            pengesahan = new Date(l.getTglPengesahan().getTime());
        }
        if(l.getTglLaporan() != null){
            laporan = new Date(l.getTglLaporan().getTime());
        }
        if(l.getTglPengesahan() != null){
            pengesahan = new Date(l.getTglPengesahan().getTime());
        }
        
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.LEGALITAS +" SET NO_AKTA_BERDIRI = (?), TGL_AKTA_BERDIRI = (?), "
                    + "NAMA_NOTARIS_BERDIRI = (?), ALAMAT_LEGALITAS = (?), TLP_LEGALITAS = (?), NO_AKTA_RUBAH1 = (?), "
                    + "TGL_AKTA_RUBAH1 = (?), NAMA_NOTARIS_RUBAH = (?), NO_AKTA_RUBAH2 = (?), TGL_AKTA_RUBAH2 = (?),"
                    + "NO_PERSETUJUAN = (?), TGL_PERSETUJUAN = (?), NO_PENGESAHAN = (?), "
                    + "TGL_PENGESAHAN = (?), NO_LAPORAN = (?), TGL_LAPORAN = (?), "
                    + "NO_PEMBERITAHUAN = (?), TGL_PEMBERITAHUAN = (?) WHERE ID_MASTER = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , l.getNo_akta_berdiri());
            ps.setDate  (2 , berdiri);
            ps.setString(3 , l.getNama_notaris_berdiri());
            ps.setString(4, l.getAlamat());
            ps.setString(5, l.getNotlp());
            ps.setString(6 , l.getNo_akta_perubahan1());
            ps.setDate  (7 , perubahan1);
            ps.setString(8, l.getNama_notaris_perubahan());
            ps.setString(9 , l.getNo_akta_perubahan2());
            ps.setDate  (10, perubahan2);
            ps.setString(11, l.getNo_perse7());
            ps.setDate  (12, perse7an );
            ps.setString(13, l.getNo_pengesahan());
            ps.setDate  (14, pengesahan);
            ps.setString(15, l.getNo_laporan());
            ps.setDate  (16, laporan);
            ps.setString(17, l.getNo_pemberitahuan());
            ps.setDate  (18, pemberitahuan);
            ps.setInt   (19, l.getId_legalitas());
            if(ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        return flag;
    }
}
