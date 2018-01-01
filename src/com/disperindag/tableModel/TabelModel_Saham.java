/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoData_Saham;
import com.disperindag.model.Data_Saham;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscar
 */
public class TabelModel_Saham extends AbstractTableModel {

    private String[] header = {"Jumlah Pemegang Saham", "Nama Lengkap", "Alamat", "Kode Pos"};
    private List<Data_Saham> ls = null;
    private daoData_Saham ds = null;
    private Connection con = null;
    private int id;

    //,"No.tlp", "Warga Negara", "NPWP", "Jumlah Saham", "Jumlah Modal"
    public TabelModel_Saham(Connection con, int id) {
        this.con = con;
        this.id = id;
        ls = new daoData_Saham(con).getSahamBy(id);
    }

    public String addSaham(Data_Saham d) throws SQLException {
        String s = "Gagal";
        if (new daoData_Saham(con).addSaham(d) == true) {
            ls = new daoData_Saham(con).getSahamBy(id);
            fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
            s = "Sukses";
        }
        return s;
    }

    public String updateSaham(Data_Saham d, int row) throws SQLException {
        String s = "Gagal";
        if (new daoData_Saham(con).UpdateSaham(d) == true) {
            ls = new daoData_Saham(con).getSahamBy(id);
            fireTableRowsUpdated(row, row);
            s = "Sukses";
        }
        return s;
    }

    public String deleteSaham(int row) throws SQLException {
        String s = "Gagal";
        if (new daoData_Saham(con).deleteSaham(ls.get(row).getId_saham()) == true) {
            ls.remove(row);
            fireTableRowsDeleted(row, row);
            s = "Sukses";
        }
        return s;
    }

    public Data_Saham getSaham(int row) {
        return ls.get(row);
    }

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ls.get(rowIndex).getJmlPemegang_saham();
            case 1:
                return ls.get(rowIndex).getNama_lengkap();
            case 2:
                return ls.get(rowIndex).getAlamat();
            case 4:
                return ls.get(rowIndex).getKodePos();
//            case 5:
//                return ls.get(rowIndex).getNoTlp();
//            case 6:
//                return ls.get(rowIndex).getWn();
//            case 7:
//                return ls.get(rowIndex).getNpwp();
//            case 8:
//                return ls.get(rowIndex).getJumlahSaham();
//            case 9:
//                return ls.get(rowIndex).getJumlahSetor();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
