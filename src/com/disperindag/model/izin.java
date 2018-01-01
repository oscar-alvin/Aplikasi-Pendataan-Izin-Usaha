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
public class izin {
    private int kode_Data;
    private int id_legalitas;
    private String jenis_izin;
    private String nomor;
    private String dikeluarkan_oleh;
    private Date tgl_berlaku;
    private int masa_laku;
    private Date tgl_selesai;

    public izin() {
    }

    public izin(int kode, int id_legalitas, String jenis_izin, String nomor, String dikeluarkan_oleh, Date tgl_berlaku, int masa_laku, Date tgl_selesai) {
        this.kode_Data = kode;
        this.id_legalitas = id_legalitas;
        this.jenis_izin = jenis_izin;
        this.nomor = nomor;
        this.dikeluarkan_oleh = dikeluarkan_oleh;
        this.tgl_berlaku = tgl_berlaku;
        this.masa_laku = masa_laku;
        this.tgl_selesai = tgl_selesai;
    }

    public int getKode_Data() {
        return kode_Data;
    }

    public void setKode_Data(int kode_Data) {
        this.kode_Data = kode_Data;
    }

    public int getId_legalitas() {
        return id_legalitas;
    }

    public void setId_legalitas(int id_legalitas) {
        this.id_legalitas = id_legalitas;
    }

    public String getJenis_izin() {
        return jenis_izin;
    }

    public void setJenis_izin(String jenis_izin) {
        this.jenis_izin = jenis_izin;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getDikeluarkan_oleh() {
        return dikeluarkan_oleh;
    }

    public void setDikeluarkan_oleh(String dikeluarkan_oleh) {
        this.dikeluarkan_oleh = dikeluarkan_oleh;
    }

    public Date getTgl_berlaku() {
        return tgl_berlaku;
    }

    public void setTgl_berlaku(Date tgl_berlaku) {
        this.tgl_berlaku = tgl_berlaku;
    }

    public int getMasa_laku() {
        return masa_laku;
    }

    public void setMasa_laku(int masa_laku) {
        this.masa_laku = masa_laku;
    }

    public Date getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(Date tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }
    
}
