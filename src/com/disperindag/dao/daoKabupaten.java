/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.kabupaten;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Shesy
 */
public class daoKabupaten {
    private Connection con;

    public daoKabupaten() {
        con = new myConnection().getConnection();
    }
    
    public List<kabupaten> getKabupaten(){
        List<kabupaten> lk = new ArrayList<kabupaten>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kabupaten ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kabupaten k = new kabupaten();
                k.setKode_kab(rs.getInt(1));
                k.setKode_prop(rs.getInt(2));
                k.setNama_kabupaten(rs.getString(3));
                k.setKode_area(rs.getInt(4));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public List<kabupaten> getKabupatenByid(int kode_prop){
        List<kabupaten> lk = new ArrayList<kabupaten>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kabupaten where kode_prop = '" +kode_prop+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kabupaten k = new kabupaten();
                k.setKode_kab(rs.getInt(1));
                k.setKode_prop(rs.getInt(2));
                k.setNama_kabupaten(rs.getString(3));
                k.setKode_area(rs.getInt(4));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public boolean addKabupaten(kabupaten k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into tabel_kabupaten values (?, ?, ?, ?)");
            ps.setInt   (1, k.getKode_kab());
            ps.setInt   (2, k.getKode_prop());
            ps.setString(3, k.getNama_kabupaten());
            ps.setInt   (4, k.getKode_area());
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
    public boolean deleteKabupaten(int k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from tabel_kabupaten where kode_kab = ?");
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
