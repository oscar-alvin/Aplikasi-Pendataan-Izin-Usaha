/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.model.Data_kegiatan;
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
public class daoData_kegiatan {
    private Connection con = null;

    public daoData_kegiatan(Connection con) {
        this.con = con;
    }
    
    public Data_kegiatan getKegiatan(int kode){
        Data_kegiatan dk = null;
        try {
            String query = "SELECT * FROM "+ MASTER.KEGIATAN +" WHERE id_master = '"+kode+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dk = new Data_kegiatan();
                dk.setId_keg(rs.getInt(1));
                dk.setKeg_usaha_pokok(rs.getString(2));
                dk.setKeg_usaha_lain(rs.getString(3));
                dk.setProduk_utama(rs.getString(4));
                dk.setProduk_lain(rs.getString(5));
                dk.setOmset_pertahun(rs.getDouble(6));
                dk.setModal_utama(rs.getDouble(7));
                dk.setModal_pinjaman(rs.getDouble(8));
                dk.setTotal_aset(rs.getDouble(9));
                dk.setKaryawanWNI(rs.getString(10));
                dk.setKaryawanWNA(rs.getString(11));
                dk.setTotalKaryawan(rs.getString(12));
                dk.setKedudukan(rs.getString(13));
                dk.setJenis_usaha(rs.getString(14));
                dk.setModalDasar(rs.getDouble(15));
                dk.setModalPenempatan(rs.getDouble(16));
                dk.setModalSetor(rs.getDouble(17));
                dk.setJmlSaham(rs.getInt(18));
                dk.setNominal(rs.getDouble(19));
                dk.setModalSAktif(rs.getDouble(20));
                dk.setModalSPasif(rs.getDouble(21));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dk;
    }
    
    public boolean updateKegiatan(Data_kegiatan dk) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "UPDATE "+ MASTER.KEGIATAN +" SET KEG_USAHA_POKOK = (?), "
                    + "KEG_USAHA_LAIN = (?), PRODUK_UTAMA = (?), PRODUK_LAIN = (?), "
                    + "OMSET_PERTAHUN = (?), MODAL_SENDIRI = (?), MODAL_PINJAMAN = (?), "
                    + "TOTAL_ASET = (?),JUMLAH_WNI = (?), JUMLAH_WNA = (?), "
                    + "TOTAL_KARYAWAN = (?), KEDUDUKAN_USAHA = (?), JENIS_USAHA = (?), "
                    + "MODAL_DASAR = (?), MODAL_PENEMPATAN = (?), MODAL_SETOR = (?), "
                    + "JUMLAH_SAHAM = (?), NOMINAL = (?), MODALSAKTIF = (?), "
                    + "MODALSPASIF = (?), SEKTOR = (?) WHERE ID_MASTER = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1 , dk.getKeg_usaha_pokok());
            ps.setString(2 , dk.getKeg_usaha_lain());
            ps.setString(3 , dk.getProduk_utama());
            ps.setString(4 , dk.getProduk_lain());
            ps.setDouble(5 , dk.getOmset_pertahun());
            ps.setDouble(6 , dk.getModal_utama());
            ps.setDouble(7 , dk.getModal_pinjaman());
            ps.setDouble(8 , dk.getTotal_aset());
            ps.setString(9 , dk.getKaryawanWNI());
            ps.setString(10, dk.getKaryawanWNA());
            ps.setString(11, dk.getTotalKaryawan());
            ps.setString(12, dk.getKedudukan());
            ps.setString(13, dk.getJenis_usaha());
            ps.setDouble(14, dk.getModalDasar());
            ps.setDouble(15, dk.getModalPenempatan());
            ps.setDouble(16, dk.getModalSetor());
            ps.setInt   (17, dk.getJmlSaham());
            ps.setDouble(18, dk.getNominal());
            ps.setDouble(19, dk.getModalSAktif());
            ps.setDouble(20, dk.getModalSPasif());
            ps.setInt   (21, dk.getSektorUsaha());
            ps.setInt   (22, dk.getId_keg());
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
