/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoData_Master;
import com.disperindag.model.Master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alvin
 */
public class TabelModel_master extends AbstractTableModel {

    private Connection con;
    private List<Master> l = null;
    private daoData_Master dm = null;
    private String[] columnName = {"Kode Data", "No.TDP", "Tanggal Pendaftaran", "Jenis Pendaftaran",
        "No.Pembaharuan", "Jenis Perusahaan", "Nama Pengurus", "Nama Perusahaan", "Alamat Perusahaan"};

    public TabelModel_master(Connection con) {
        this.con = con;
        dm = new daoData_Master(con);
        l = new ArrayList<Master>();
    }

    public void setData(List<Master> lm) {
        l.removeAll(l);
        for (Master m : lm) {
            l.add(m);
        }
        fireTableDataChanged();
    }
    
    public void cari(String k1, String k2) throws SQLException{
        ResultSet rs = dm.getMasterBy(con, k1, k2);
        setData(dm.getAllMaster(rs));
    }

    public Master getMaster(int i) {
        return l.get(i);
    }

    public String delete_master(int row) throws SQLException {
        String s = "Gagal";
        if (dm.deleteMaster(l.get(row).getId_master()) == true) {
            l.remove(row);
            fireTableRowsDeleted(row, row);
            s = "sukses";
        }
        return s;
    }

    @Override
    public int getRowCount() {
        return l.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return l.get(rowIndex).getId_master();
            case 1:
                return l.get(rowIndex).getNo_tdp();
            case 2:
                return l.get(rowIndex).getTgl_regis();
            case 3:
                return l.get(rowIndex).getJenis_regis();
            case 4:
                return l.get(rowIndex).getNo_pembaharuan();
            case 5:
                return l.get(rowIndex).getJenis_perusahaan();
            case 6:
                return l.get(rowIndex).getNama_pengurus();
            case 7:
                return l.get(rowIndex).getNama_perusahaan();
            case 8:
                return l.get(rowIndex).getAlamat_perusahaan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }
}
