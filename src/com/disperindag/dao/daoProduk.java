/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvin
 */
public class daoProduk {
    private Connection con = null;

    public daoProduk() {
        con = new myConnection().getConnection();
    }
    
    public List<produk> getProdukBy(String method, String key){
        List<produk> lp = new ArrayList<produk>();
        try {
            String query = "SELECT * FROM tabel_produk WHERE "+method+" LIKE '%"+key+"%'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                produk p = new produk();
                p.setKode_produk(rs.getString(1));
                p.setUraian(rs.getString(2));
                p.setSatuan(rs.getString(3));
                p.setKode_lama(rs.getString(4));
                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }
    
    public List<produk> getAllProduk(){
        List<produk> lp = new ArrayList<produk>();
        try {
            String query = "SELECT * FROM tabel_produk order by URAIAN asc";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                produk p = new produk();
                p.setKode_produk(rs.getString(1));
                p.setUraian(rs.getString(2));
                p.setSatuan(rs.getString(3));
                p.setKode_lama(rs.getString(4));
                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lp;
    }
    
    public boolean insertProduk(produk p) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "INSERT INTO tabel_produk VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getKode_produk());
            ps.setString(2, p.getUraian());
            ps.setString(3, p.getSatuan());
            ps.setString(4, p.getKode_lama());
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean hapusProduk(String kode) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            String query = "DELETE FROM tabel_produk WHERE kode = (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, kode);
            if (ps.executeUpdate() == 1){
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
