/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author oscar
 */
public class Data_Saham {
    private int id_master;
    private int id_saham;
    private int jmlPemegang_saham;
    private String nama_lengkap;
    private String alamat;
    private String kodePos;
    private String noTlp;
    private String wn;
    private String npwp;
    private int jumlahSaham;
    private Double jumlahSetor;

    public Data_Saham() {
    }

    public Data_Saham(int id_master, int id_saham, int jmlPemegang_saham, String nama_lengkap, String alamat, String kodePos, String noTlp, String wn, String npwp, int jumlahSaham, Double jumlahSetor) {
        this.id_master = id_master;
        this.id_saham = id_saham;
        this.jmlPemegang_saham = jmlPemegang_saham;
        this.nama_lengkap = nama_lengkap;
        this.alamat = alamat;
        this.kodePos = kodePos;
        this.noTlp = noTlp;
        this.wn = wn;
        this.npwp = npwp;
        this.jumlahSaham = jumlahSaham;
        this.jumlahSetor = jumlahSetor;
    }
    
    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_saham() {
        return id_saham;
    }

    public void setId_saham(int id_saham) {
        this.id_saham = id_saham;
    }

    public int getJmlPemegang_saham() {
        return jmlPemegang_saham;
    }

    public void setJmlPemegang_saham(int jmlPemegang_saham) {
        this.jmlPemegang_saham = jmlPemegang_saham;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public int getJumlahSaham() {
        return jumlahSaham;
    }

    public void setJumlahSaham(int jumlahSaham) {
        this.jumlahSaham = jumlahSaham;
    }

    public Double getJumlahSetor() {
        return jumlahSetor;
    }

    public void setJumlahSetor(Double jumlahSetor) {
        this.jumlahSetor = jumlahSetor;
    }
    
}
