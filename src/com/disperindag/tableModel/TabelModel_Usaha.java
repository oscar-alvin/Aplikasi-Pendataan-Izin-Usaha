/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoKegUsaha;
import com.disperindag.model.keg_usaha;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscar
 */
public class TabelModel_Usaha extends AbstractTableModel{
    private List<keg_usaha> lk = null;
    private daoKegUsaha du = new daoKegUsaha();
    private String[] usaha = {"KODE USAHA", "URAIAN"};

    public TabelModel_Usaha() {
        lk = du.getAllUsaha();
    }
    
    public void getUsahaBy(String k1, String k2){
        lk = du.getUsahaBy(k1, k2);
        fireTableDataChanged();
    }
    
    public void refreshData(){
        lk = du.getAllUsaha();
        fireTableDataChanged();
    }
    
    public String addUsaha(keg_usaha ku) throws SQLException{
        String s = "gagal";
        if(du.insertUsaha(ku) == true){
            lk.add(ku);
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
            s = "sukses";
        }
        return s;
    }
    
    public String hpsUsaha(int row) throws SQLException{
        String s = "gagal";
        if(du.deleteUsaha(lk.get(row).getKode_usaha()) == true){
            lk.remove(row);
            fireTableRowsDeleted(row, row);
            s = "sukses";
        }
        return s;
    }
    
    public keg_usaha getUsaha(int row){
        return lk.get(row);
    }

    @Override
    public int getRowCount() {
        return lk.size();
    }

    @Override
    public int getColumnCount() {
        return usaha.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return lk.get(rowIndex).getKode_usaha();
            case 1: return lk.get(rowIndex).getNama_usaha();
            default :return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return usaha[column];
    }
    
}
