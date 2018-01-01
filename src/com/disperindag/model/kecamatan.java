/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Shesy
 */
public class kecamatan {
    private int kode_kec;
    private int kode_kab;
    private String nama_kecamatan;

    public kecamatan() {
    }

    public kecamatan(int kode_kec, int kode_kab, String nama_kecamatan) {
        this.kode_kec = kode_kec;
        this.kode_kab = kode_kab;
        this.nama_kecamatan = nama_kecamatan;
    }

    public int getKode_kec() {
        return kode_kec;
    }

    public void setKode_kec(int kode_kec) {
        this.kode_kec = kode_kec;
    }

    public int getKode_kab() {
        return kode_kab;
    }

    public void setKode_kab(int kode_kab) {
        this.kode_kab = kode_kab;
    }

    public String getNama_kecamatan() {
        return nama_kecamatan;
    }

    public void setNama_kecamatan(String nama_kecamatan) {
        this.nama_kecamatan = nama_kecamatan;
    }
}
