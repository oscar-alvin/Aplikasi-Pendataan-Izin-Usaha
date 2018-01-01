/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Shesy
 */
public class kabupaten {
    private int kode_kab;
    private int kode_prop;
    private String nama_kabupaten;
    private int kode_area;

    public kabupaten() {
    }

    public kabupaten(int kode_kab, int kode_prop, String nama_kabupaten, int kode_area) {
        this.kode_kab = kode_kab;
        this.kode_prop = kode_prop;
        this.nama_kabupaten = nama_kabupaten;
        this.kode_area = kode_area;
    }
    
    public int getKode_kab() {
        return kode_kab;
    }

    public void setKode_kab(int kode_kab) {
        this.kode_kab = kode_kab;
    }

    public int getKode_prop() {
        return kode_prop;
    }

    public void setKode_prop(int kode_prop) {
        this.kode_prop = kode_prop;
    }

    public String getNama_kabupaten() {
        return nama_kabupaten;
    }

    public void setNama_kabupaten(String nama_kabupaten) {
        this.nama_kabupaten = nama_kabupaten;
    }

    public int getKode_area() {
        return kode_area;
    }

    public void setKode_area(int kode_area) {
        this.kode_area = kode_area;
    }
}
