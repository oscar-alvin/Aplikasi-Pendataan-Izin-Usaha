/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author TOSHIBA
 */
public class Data_lokasi {
    private int id_lokasi;
    private String nama_perusahaan;
    private String alamat_perusahaan;
    private String nama_prop;
    private String nama_kab;
    private String nama_kec;
    private String nama_kel;
    private String kode_pos;
    private String no_tlp;
    private String fax;
    private String email;

    public Data_lokasi() {
    }

    public Data_lokasi(int id_lokasi, String nama_perusahaan, String alamat_perusahaan, String nama_prop, String nama_kab, String nama_kec, String nama_kel, String kode_pos, String no_tlp, String fax, String email) {
        this.id_lokasi = id_lokasi;
        this.nama_perusahaan = nama_perusahaan;
        this.alamat_perusahaan = alamat_perusahaan;
        this.nama_prop = nama_prop;
        this.nama_kab = nama_kab;
        this.nama_kec = nama_kec;
        this.nama_kel = nama_kel;
        this.kode_pos = kode_pos;
        this.no_tlp = no_tlp;
        this.fax = fax;
        this.email = email;
    }

    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }
    
    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public void setNama_perusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }

    public String getAlamat_perusahaan() {
        return alamat_perusahaan;
    }

    public void setAlamat_perusahaan(String alamat_perusahaan) {
        this.alamat_perusahaan = alamat_perusahaan;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
