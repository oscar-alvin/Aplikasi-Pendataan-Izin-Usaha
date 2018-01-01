/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.kecamatan;
import com.disperindag.model.kelurahan;
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
public class daoKelurahan {
    private Connection con;

    public daoKelurahan() {
        con = new myConnection().getConnection();
    }
    
    public List<kelurahan> getKelurahan(){
        List<kelurahan> lk = new ArrayList<kelurahan>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kelurahan");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kelurahan k = new kelurahan();
                k.setId_kel(rs.getString(1));
                k.setNama_kelurahan(rs.getString(2));
                k.setId_kec(rs.getInt(3));
                k.setKodepos(rs.getInt(4));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public List<kelurahan> getKelurahanByid(int kode_kec){
        List<kelurahan> lk = new ArrayList<kelurahan>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_kelurahan where kode_kec = '" +kode_kec+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                kelurahan k = new kelurahan();
                k.setId_kel(rs.getString(1));
                k.setNama_kelurahan(rs.getString(2));
                k.setId_kec(rs.getInt(3));
                k.setKodepos(rs.getInt(4));
                lk.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lk;
    }
    
    public boolean addKelurahan(kelurahan k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into tabel_kelurahan values (?,?,?,?)");
            ps.setString(1, k.getId_kel());
            ps.setString(2, k.getNama_kelurahan());
            ps.setInt   (3, k.getId_kec());
            ps.setInt   (4, k.getKodepos());
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
    
    public boolean deleteKel(String k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from tabel_kelurahan where id_kelurahan = (?)");
            ps.setString(1, k);
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
