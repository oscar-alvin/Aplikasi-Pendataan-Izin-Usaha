/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.kecamatan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class daoKecamatan {
    private Connection con;

    public daoKecamatan() {
        con = new myConnection().getConnection();
    }
    
    public List<kecamatan> getKecamatan(){
        List<kecamatan> lk = new ArrayList<kecamatan>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kecamatan ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kecamatan k = new kecamatan();
                k.setKode_kec(rs.getInt(1));
                k.setKode_kab(rs.getInt(2));
                k.setNama_kecamatan(rs.getString(3));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public List<kecamatan> getKecamatanByid(int kode_kec){
        List<kecamatan> lk = new ArrayList<kecamatan>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kecamatan where kode_kab = '" +kode_kec+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kecamatan k = new kecamatan();
                k.setKode_kec(rs.getInt(1));
                k.setKode_kab(rs.getInt(2));
                k.setNama_kecamatan(rs.getString(3));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public boolean addKecamatan(kecamatan k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into tabel_kecamatan values (?, ?, ?)");
            ps.setInt   (1, k.getKode_kec());
            ps.setInt   (2, k.getKode_kab());
            ps.setString(3, k.getNama_kecamatan());
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
    public boolean deleteKec(int k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from tabel_kecamatan where kode_kec = ?");
            ps.setInt(1, k);
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
}
