/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Shesy
 */
public class propinsi {
    private int id_prop;
    private String nama_prop;

    public propinsi() {
    }

    public propinsi(int id_prop, String nama_prop) {
        this.id_prop = id_prop;
        this.nama_prop = nama_prop;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public String getNama_prop() {
        return nama_prop;
    }

    public void setNama_prop(String nama_prop) {
        this.nama_prop = nama_prop;
    }
}
