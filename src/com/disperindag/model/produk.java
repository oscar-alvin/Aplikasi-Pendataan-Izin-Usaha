/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Alvin
 */
public class produk {
    private String kode_produk;
    private String uraian;
    private String satuan;
    private String kode_lama;

    public produk() {
    }

    public produk(String kode_produk, String uraian, String satuan, String kode_lama) {
        this.kode_produk = kode_produk;
        this.uraian = uraian;
        this.satuan = satuan;
        this.kode_lama = kode_lama;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getKode_lama() {
        return kode_lama;
    }

    public void setKode_lama(String kode_lama) {
        this.kode_lama = kode_lama;
    }
    
}
