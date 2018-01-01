/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dao;

import com.disperindag.koneksi.myConnection;
import com.disperindag.model.propinsi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class daoPropinsi {
    private Connection con;

    public daoPropinsi() {
        con = new myConnection().getConnection();
    }
    
    public List<propinsi> getPropinsi(){
        List<propinsi> lp = new ArrayList<propinsi>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tabel_propinsi ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                propinsi p = new propinsi();
                p.setId_prop(rs.getInt(1));
                p.setNama_prop(rs.getString(2));
                lp.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lp;
    }
    
    public boolean addPropinsi(propinsi p) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into tabel_propinsi values (?, ?)");
            ps.setInt(1, p.getId_prop());
            ps.setString(2, p.getNama_prop());
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
        }
        return flag;
    }
    
    public boolean deleteProp(int k) throws SQLException{
        boolean flag = false;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("delete from tabel_propinsi where kode_prop = ?");
            ps.setInt(1, k);
            if (ps.executeUpdate() == 1){
                flag = true;
                con.commit();
            }
        } catch (Exception e) {
            con.rollback();
        }
        return flag;
    }
}
