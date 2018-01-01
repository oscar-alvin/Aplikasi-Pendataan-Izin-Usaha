/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Alvin
 */
public class keg_usaha {
    private int kode_sektor;
    private String kode_usaha;
    private String nama_usaha;

    public keg_usaha() {
    }

    public keg_usaha(int ks, String kode_usaha, String nama_usaha) {
        this.kode_sektor = ks;
        this.kode_usaha = kode_usaha;
        this.nama_usaha = nama_usaha;
    }

    public int getKS() {
        return kode_sektor;
    }

    public void setKS(int kg) {
        this.kode_sektor = kg;
    }

    public String getKode_usaha() {
        return kode_usaha;
    }

    public void setKode_usaha(String kode_usaha) {
        this.kode_usaha = kode_usaha;
    }

    public String getNama_usaha() {
        return nama_usaha;
    }

    public void setNama_usaha(String nama_usaha) {
        this.nama_usaha = nama_usaha;
    }
}
