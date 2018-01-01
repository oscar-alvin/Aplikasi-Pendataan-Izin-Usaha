/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_umum;
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
public class daoData_Umum {
    private Connection con = null;

    public daoData_Umum(Connection con) {
        this.con = con;
    }
    
    public Data_umum getDU(int kode){
        Data_umum du = null;
        try {
            String query = "SELECT * FROM "+ MASTER.UMUM +" WHERE id_master = '"+kode+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                du = new Data_umum();
                du.setId_umum(rs.getInt(1));
                du.setNama_kelompok(rs.getString(2));
                du.setLokasi_produksi(rs.getString(3));
                du.setNama_prop(rs.getString(4));
                du.setNama_kab(rs.getString(5));
                du.setJumlah_bank(rs.getInt(6));
                du.setNpwp(rs.getString(7));
                du.setTgl_berdiri(rs.getDate(8));
                du.setTgl_mulai(rs.getDate(9));
                du.setKerja_sama(rs.getString(10));
                du.setHak_cipta(rs.getString(11));
                du.setNo_hak_cipta(rs.getString(12));
                du.setHak_paten(rs.getString(13));
                du.setNo_hak_paten(rs.getString(14));
                du.setMerek_dagang(rs.getString(15));
                du.setNo_merek_dagang(rs.getString(16));
                du.setBentuk_koperasi(rs.getString(17));
                du.setJenis_koperasi(rs.getString(18));
                du.setJumlah_anggota(rs.getString(19));
                du.setJangka_Pberdiri(rs.getInt(20));
                du.setStatus_perusahaan(rs.getString(21));
                du.setPenanaman_modal(rs.getString(22));
                du.setProp_induk(rs.getString(23));
                du.setTDP_induk(rs.getString(24));
                du.setAlamat_Pinduk(rs.getString(25));
                du.setProp_induk(rs.getString(26));
                du.setKab_induk(rs.getString(27));
                du.setKec_induk(rs.getString(28));
                du.setKel_induk(rs.getString(29));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return du;
    }
    
    public boolean updateDataUMUM(Data_umum du) throws SQLException{
        boolean flag = false;
        
        Date tglBerdiri = null;
        Date tglMulaiKeg = null;
        
        if(du.getTgl_berdiri() != null){
            tglBerdiri = new Date(du.getTgl_berdiri().getTime() );
        }
        if(du.getTgl_mulai() != null){
            tglMulaiKeg = new Date( du.getTgl_mulai().getTime() );
        }
        
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.UMUM +" SET nama_kel = (?), lokasi_produksi = (?), NAMA_PROP_UMUM = (?), "
                    + "NAMA_KAB_UMUM = (?), JUMLAH_BANK = (?), NPWP = (?), TGL_BERDIRI = (?), TGL_MULAI_KEG = (?), "
                    + "BENTUK_KERJA_SAMA = (?), PEMEGANG_HAK_CIPTA = (?), NO_HAK_CIPTA = (?), PEMEGANG_HAK_PATEN = (?),"
                    + "NO_HAK_PATEN = (?), MERK_DAGANG = (?), NO_MERK_DAGANG = (?), BENTUK_KOPERASI = (?), "
                    + "JENIS_KOPERASI = (?), JUMLAH_ANGGOTA = (?), JANGKA_PBERDIRI = (?), "
                    + "STATUS_PERUSAHAAN = (?), PENANAMAN_MODAL = (?), NAMA_PINDUK = (?), NO_TDP_INDUK = (?), "
                    + "ALAMAT_PINDUK = (?), PROP_INDUK = (?),KAB_INDUK = (?), KEC_INDUK = (?), KEL_INDUK = (?) "
                    + "WHERE ID_MASTER = (?)"; 
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , du.getNama_kelompok());
            ps.setString(2 , du.getLokasi_produksi());
            ps.setString(3 , du.getNama_prop());
            ps.setString(4 , du.getNama_kab());
            ps.setInt   (5 , du.getJumlah_bank());
            ps.setString(6 , du.getNpwp());
            ps.setDate  (7 , tglBerdiri );
            ps.setDate  (8 , tglMulaiKeg );
            ps.setString(9 , du.getKerja_sama());
            ps.setString(10, du.getHak_cipta());
            ps.setString(11, du.getNo_hak_cipta());
            ps.setString(12, du.getHak_paten());
            ps.setString(13, du.getNo_hak_paten());
            ps.setString(14, du.getMerek_dagang());
            ps.setString(15, du.getNo_merek_dagang());
            ps.setString(16, du.getBentuk_koperasi());
            ps.setString(17, du.getJenis_koperasi());
            ps.setString(18, du.getJumlah_anggota());
            ps.setInt   (19, du.getJangka_Pberdiri());
            ps.setString(20, du.getStatus_perusahaan());
            ps.setString(21, du.getPenanaman_modal());
            ps.setString(22, du.getPerusahaan_induk());
            ps.setString(23, du.getTDP_induk());
            ps.setString(24, du.getAlamat_Pinduk());
            ps.setString(25, du.getProp_induk());
            ps.setString(26, du.getKab_induk());
            ps.setString(27, du.getKec_induk());
            ps.setString(28, du.getKel_induk());
            ps.setInt   (29, du.getId_umum());
            if(ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
}
