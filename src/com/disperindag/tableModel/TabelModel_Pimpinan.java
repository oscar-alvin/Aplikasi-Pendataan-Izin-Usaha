/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoData_Pimpinan;
import com.disperindag.model.Data_pimpinan;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscar
 */
public class TabelModel_Pimpinan extends AbstractTableModel {

    private List<Data_pimpinan> lp = null;
    private daoData_Pimpinan dp = null;
    private int id;
    private String[] header = {"Kedudukan", "Nama Lengkap", "Alamat", "Kode Pos"};
//      "Jumlah Pengurus", "Jumlah Pengawas", "No.tlp", "Kewarganegaraan"

    public TabelModel_Pimpinan(Connection con, int id) {
        this.id = id;
        dp = new daoData_Pimpinan(con);
        lp = dp.getPimpinanById(id);
    }

    public void refreshData() {
        lp = dp.getPimpinanById(id);
        fireTableDataChanged();
    }

    public Data_pimpinan getPimpinan(int row) {
        return lp.get(row);
    }

    public String addPimpinan(Data_pimpinan d) throws SQLException {
        String s = "gagal";
        if (dp.insertPimpinan(d) == true) {
            lp = dp.getPimpinanById(id);
            fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
            s = "sukses";
        }
        return s;
    }

    public String updatePimpinan(Data_pimpinan d, int row) throws SQLException {
        String s = "gagal";
        if (dp.updatePimpinan(d) == true) {
            lp = dp.getPimpinanById(id);
            fireTableRowsUpdated(row, row);
            s = "sukses";
        }
        return s;
    }

    public String deletePimpinan(int row) throws SQLException {
        String s = "gagal";
        if (dp.deletePimpinan(lp.get(row).getId_pimpinan()) == true) {
            lp.remove(row);
            fireTableRowsDeleted(row, row);
            s = "sukses";
        }
        return s;
    }

    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lp.get(rowIndex).getKedudukan();
            case 1:
                return lp.get(rowIndex).getNama_lengkap();
            case 2:
                return lp.get(rowIndex).getAlamat();
            case 3:
                return lp.get(rowIndex).getKode_pos();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
