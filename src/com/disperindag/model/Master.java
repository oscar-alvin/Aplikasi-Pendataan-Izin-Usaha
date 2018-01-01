/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

import java.util.Date;

/**
 *
 * @author Alvin
 */
public class Master {
    private int id_master;
    private String no_tdp;
    private Date tgl_regis;
    private String jenis_regis;
    private int no_pembaharuan;
    private String jenis_perusahaan;
    private String nama_pengurus;
    private String nama_perusahaan;
    private String alamat_perusahaan;

    public Master() {
    }

    public Master(int id_master, String no_tdp, Date tgl_regis, String jenis_regis, int no_pembaharuan, String jenis_perusahaan, String nama_pengurus, String nama_perusahaan, String alamat_perusahaan) {
        this.id_master = id_master;
        this.no_tdp = no_tdp;
        this.tgl_regis = tgl_regis;
        this.jenis_regis = jenis_regis;
        this.no_pembaharuan = no_pembaharuan;
        this.jenis_perusahaan = jenis_perusahaan;
        this.nama_pengurus = nama_pengurus;
        this.nama_perusahaan = nama_perusahaan;
        this.alamat_perusahaan = alamat_perusahaan;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public String getNo_tdp() {
        return no_tdp;
    }

    public void setNo_tdp(String no_tdp) {
        this.no_tdp = no_tdp;
    }

    public Date getTgl_regis() {
        return tgl_regis;
    }

    public void setTgl_regis(Date tgl_regis) {
        this.tgl_regis = tgl_regis;
    }

    public String getJenis_regis() {
        return jenis_regis;
    }

    public void setJenis_regis(String jenis_regis) {
        this.jenis_regis = jenis_regis;
    }

    public int getNo_pembaharuan() {
        return no_pembaharuan;
    }

    public void setNo_pembaharuan(int no_pembaharuan) {
        this.no_pembaharuan = no_pembaharuan;
    }

    public String getJenis_perusahaan() {
        return jenis_perusahaan;
    }

    public void setJenis_perusahaan(String jenis_perusahaan) {
        this.jenis_perusahaan = jenis_perusahaan;
    }

    public String getNama_pengurus() {
        return nama_pengurus;
    }

    public void setNama_pengurus(String nama_pengurus) {
        this.nama_pengurus = nama_pengurus;
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
    
}
