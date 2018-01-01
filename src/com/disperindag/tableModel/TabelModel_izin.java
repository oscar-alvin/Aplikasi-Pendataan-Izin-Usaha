/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoIzin_legalitas;
import com.disperindag.model.izin;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alvin
 */
public class TabelModel_izin extends AbstractTableModel {

    private List<izin> li = null;
    private daoIzin_legalitas d = new daoIzin_legalitas();
    private String[] izin = {"Jenis Izin", "Nomor", "Dikeluarkan Oleh", "Tanggal Berlaku", "Masa Laku"};
    private int _id;
    private SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

    public TabelModel_izin(int id) {
        this._id = id;
        li = d.getIzinById(_id);
    }

    public String addIzin(izin i) throws SQLException {
        String s = "gagal";
        if (d.insertIzin(i) == true) {
            li = d.getIzinById(_id);
            fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
            s = "sukses";
        }
        return s;
    }

    public String hpsIzin(int row) throws SQLException {
        String s = "gagal";
        if (d.deleteIzin(li.get(row).getKode_Data()) == true) {
            li.remove(row);
            fireTableRowsDeleted(row, row);
            s = "sukses";
        }
        return s;
    }

    public izin get(int index) {
        return li.get(index);
    }

    @Override
    public int getRowCount() {
        return li.size();
    }

    @Override
    public int getColumnCount() {
        return izin.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return li.get(rowIndex).getJenis_izin();
            case 1:
                return li.get(rowIndex).getNomor();
            case 2:
                return li.get(rowIndex).getDikeluarkan_oleh();
            case 3:
                return f.format(li.get(rowIndex).getTgl_berlaku());
            case 4:
                return li.get(rowIndex).getMasa_laku();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return izin[column];
    }
}
