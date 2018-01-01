/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author oscar
 */
public class Data_KagegoriP {
    private int id_master;
    private int id_kategori;
    private String nama_perusahaan;
    private String no_tdp;
    private String alamat;
    private String kabupaten;
    private String propinsi;
    private String kode_pos;
    private String notlp;
    private String statusP;
    private String jenisKegUsaha;

    public Data_KagegoriP() {
    }

    public Data_KagegoriP(int id_master, int id_kategori, String nama_perusahaan, String no_tdp, String alamat, String kabupaten, String propinsi, String kode_pos, String notlp, String statusP, String jenisKegUsaha) {
        this.id_master = id_master;
        this.id_kategori = id_kategori;
        this.nama_perusahaan = nama_perusahaan;
        this.no_tdp = no_tdp;
        this.alamat = alamat;
        this.kabupaten = kabupaten;
        this.propinsi = propinsi;
        this.kode_pos = kode_pos;
        this.notlp = notlp;
        this.statusP = statusP;
        this.jenisKegUsaha = jenisKegUsaha;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public void setNama_perusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }

    public String getNo_tdp() {
        return no_tdp;
    }

    public void setNo_tdp(String no_tdp) {
        this.no_tdp = no_tdp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(String propinsi) {
        this.propinsi = propinsi;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getNotlp() {
        return notlp;
    }

    public void setNotlp(String notlp) {
        this.notlp = notlp;
    }

    public String getStatusP() {
        return statusP;
    }

    public void setStatusP(String statusP) {
        this.statusP = statusP;
    }

    public String getJenisKegUsaha() {
        return jenisKegUsaha;
    }

    public void setJenisKegUsaha(String jenisKegUsaha) {
        this.jenisKegUsaha = jenisKegUsaha;
    }
    
}
