/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.tableModel;

import com.disperindag.dao.daoProduk;
import com.disperindag.model.produk;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oscar
 */
public class TabelModel_Produk extends AbstractTableModel{
    private List<produk> lp = null;
    private daoProduk    dp = new daoProduk();
    private String[] produk = {"KODE PRODUK", "URAIAN", "SATUAN", "KODE LAMA"};

    public TabelModel_Produk() {
        lp = dp.getAllProduk();
    }
    
    public void getProdukBy(String k, String key){
        lp = dp.getProdukBy(k, key);
        fireTableDataChanged();
    }
    
    public void refresh(){
        lp = dp.getAllProduk();
        fireTableDataChanged();
    }
    
    public String addProduk(produk p) throws SQLException{
        String s = "gagal";
        if(dp.insertProduk(p) == true){
            lp.add(p);
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
            s = "sukses";
        }
        return s;
    }
    
    public String hpsProduk(int row) throws SQLException{
        String s = "gagal";
        if(dp.hapusProduk(lp.get(row).getKode_produk()) == true){
            lp.remove(row);
            fireTableRowsDeleted(row, row);
            s = "sukses";
        }
        return s;
    }
    
    public produk getProduk(int row){
        return lp.get(row);
    }

    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return produk.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return lp.get(rowIndex).getKode_produk();
            case 1: return lp.get(rowIndex).getUraian();
            case 2: return lp.get(rowIndex).getSatuan();
            case 3: return lp.get(rowIndex).getKode_lama();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return produk[column];
    }
    
}
