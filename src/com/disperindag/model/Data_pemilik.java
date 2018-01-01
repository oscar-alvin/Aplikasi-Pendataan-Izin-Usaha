/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

import java.util.Date;

/**
 *
 * @author TOSHIBA
 */
public class Data_pemilik {
    private int id_pemilik;
    private String nama_pemilik;
    private String tempat_lahir;
    private Date tanggal_lahir;
    private String alamat_rumah;
    private String nama_prop;
    private String nama_kab;
    private String nama_kec;
    private String nama_kel;
    private String no_tlp;
    private String no_ktp;
    private String kewarganegaraan;

    public Data_pemilik() {
    }

    public Data_pemilik(int id_pemilik, String nama_pemilik, String tempat_lahir, Date tanggal_lahir, String alamat_rumah, String nama_prop, String nama_kab, String nama_kec, String nama_kel, String no_tlp, String no_ktp, String kewarganegaraan) {
        this.id_pemilik = id_pemilik;
        this.nama_pemilik = nama_pemilik;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.alamat_rumah = alamat_rumah;
        this.nama_prop = nama_prop;
        this.nama_kab = nama_kab;
        this.nama_kec = nama_kec;
        this.nama_kel = nama_kel;
        this.no_tlp = no_tlp;
        this.no_ktp = no_ktp;
        this.kewarganegaraan = kewarganegaraan;
    }

    public int getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(int id_pemilik) {
        this.id_pemilik = id_pemilik;
    }
    
    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat_rumah() {
        return alamat_rumah;
    }

    public void setAlamat_rumah(String alamat_rumah) {
        this.alamat_rumah = alamat_rumah;
    }

    public String getNama_prop() {
        return nama_prop;
    }

    public void setNama_prop(String nama_prop) {
        this.nama_prop = nama_prop;
    }

    public String getNama_kab() {
        return nama_kab;
    }

    public void setNama_kab(String nama_kab) {
        this.nama_kab = nama_kab;
    }

    public String getNama_kec() {
        return nama_kec;
    }

    public void setNama_kec(String nama_kec) {
        this.nama_kec = nama_kec;
    }

    public String getNama_kel() {
        return nama_kel;
    }

    public void setNama_kel(String nama_kel) {
        this.nama_kel = nama_kel;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }
}
