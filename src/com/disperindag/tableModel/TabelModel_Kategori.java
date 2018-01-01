/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoData_KategoriP;
import com.disperindag.model.Data_KagegoriP;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscar
 */
public class TabelModel_Kategori extends AbstractTableModel {

    private List<Data_KagegoriP> lk = null;
    private daoData_KategoriP dk = null;
    private String[] header = {"Nama Perusahaan", "No.TDP", "Alamat", "Kode Pos"};
    private int id;

    //, "Kab/Kota/Madya", "Propinsi", "No.tlp", "Status Perusahaan", "Jenis Keg. Usaha"
    public TabelModel_Kategori(Connection con, int id) {
        this.id = id;
        dk = new daoData_KategoriP(con);
        lk = dk.getKategoriBy(id);
    }

    public String addKategori(Data_KagegoriP kp) throws SQLException {
        String s = "Gagal";
            if (dk.addKategori(kp) == true) {
                lk = dk.getKategoriBy(id);
                fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
                s = "Sukses";
            }
        return s;
    }

    public String updateKategori(Data_KagegoriP kp, int row) {
        String s = "Gagal";
        try {
            if (dk.updateKategori(kp) == true) {
                lk = dk.getKategoriBy(id);
                fireTableRowsUpdated(row, row);
                s = "Sukses";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public String deleteKategori(int row) {
        String s = "Gagal";
        try {
            if (dk.deleteKategori(lk.get(row).getId_kategori()) == true) {
                lk.remove(row);
                fireTableRowsDeleted(row, row);
                s = "Sukses";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Data_KagegoriP getKategori(int index) {
        return lk.get(index);
    }

    @Override
    public int getRowCount() {
        return lk.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lk.get(rowIndex).getNama_perusahaan();
            case 1:
                return lk.get(rowIndex).getNo_tdp();
            case 2:
                return lk.get(rowIndex).getAlamat();
            case 3:
                return lk.get(rowIndex).getKode_pos();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
