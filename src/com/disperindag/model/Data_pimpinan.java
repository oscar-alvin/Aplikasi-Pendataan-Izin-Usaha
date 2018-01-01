/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Alvin
 */
public class Data_pimpinan {
    private int id_master;
    private int id_pimpinan;
    private String kedudukan;
    private String nama_lengkap;
    private String alamat;
    private String kode_pos;
    private String no_tlp;
    private String kewarganegaraan;
    private int jmlSaham;
    private double jmlModal;
    private int pengurus;
    private int pengawas;
    private int direktur;
    private int komisaris;
    private int sa;
    private int sp;
    private int sabaru;
    private int spbaru;

    public Data_pimpinan() {
    }

    public Data_pimpinan(int id_master, int id_pimpinan, String kedudukan, String nama_lengkap, String alamat, String kode_pos, String no_tlp, String kewarganegaraan, int jmlSaham, double jmlModal, int pengurus, int pengawas, int direktur, int komisaris, int sa, int sp, int sabaru, int spbaru) {
        this.id_master = id_master;
        this.id_pimpinan = id_pimpinan;
        this.kedudukan = kedudukan;
        this.nama_lengkap = nama_lengkap;
        this.alamat = alamat;
        this.kode_pos = kode_pos;
        this.no_tlp = no_tlp;
        this.kewarganegaraan = kewarganegaraan;
        this.jmlSaham = jmlSaham;
        this.jmlModal = jmlModal;
        this.pengurus = pengurus;
        this.pengawas = pengawas;
        this.direktur = direktur;
        this.komisaris = komisaris;
        this.sa = sa;
        this.sp = sp;
        this.sabaru = sabaru;
        this.spbaru = spbaru;
    }
    
    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_pimpinan() {
        return id_pimpinan;
    }

    public void setId_pimpinan(int id_pimpinan) {
        this.id_pimpinan = id_pimpinan;
    }

    public String getKedudukan() {
        return kedudukan;
    }

    public void setKedudukan(String kedudukan) {
        this.kedudukan = kedudukan;
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

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public int getJmlSaham() {
        return jmlSaham;
    }

    public void setJmlSaham(int jmlSaham) {
        this.jmlSaham = jmlSaham;
    }

    public double getJmlModal() {
        return jmlModal;
    }

    public void setJmlModal(double jmlModal) {
        this.jmlModal = jmlModal;
    }

    public int getPengurus() {
        return pengurus;
    }

    public void setPengurus(int pengurus) {
        this.pengurus = pengurus;
    }

    public int getPengawas() {
        return pengawas;
    }

    public void setPengawas(int pengawas) {
        this.pengawas = pengawas;
    }

    public int getDirektur() {
        return direktur;
    }

    public void setDirektur(int direktur) {
        this.direktur = direktur;
    }

    public int getKomisaris() {
        return komisaris;
    }

    public void setKomisaris(int komisaris) {
        this.komisaris = komisaris;
    }

    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getSabaru() {
        return sabaru;
    }

    public void setSabaru(int sabaru) {
        this.sabaru = sabaru;
    }

    public int getSpbaru() {
        return spbaru;
    }

    public void setSpbaru(int spbaru) {
        this.spbaru = spbaru;
    }
    
}
