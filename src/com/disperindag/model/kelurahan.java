/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Shesy
 */
public class kelurahan {
    private String id_kel;
    private String nama_kelurahan;
    private int id_kec;
    private int kodepos;

    public kelurahan() {
    }

    public kelurahan(String id_kel, String nama_kelurahan, int id_kec, int kodepos) {
        this.id_kel = id_kel;
        this.nama_kelurahan = nama_kelurahan;
        this.id_kec = id_kec;
        this.kodepos = kodepos;
    }

    public String getId_kel() {
        return id_kel;
    }

    public void setId_kel(String id_kel) {
        this.id_kel = id_kel;
    }

    public String getNama_kelurahan() {
        return nama_kelurahan;
    }

    public void setNama_kelurahan(String nama_kelurahan) {
        this.nama_kelurahan = nama_kelurahan;
    }

    public int getId_kec() {
        return id_kec;
    }

    public void setId_kec(int id_kec) {
        this.id_kec = id_kec;
    }

    public int getKodepos() {
        return kodepos;
    }

    public void setKodepos(int kodepos) {
        this.kodepos = kodepos;
    }
    
}
