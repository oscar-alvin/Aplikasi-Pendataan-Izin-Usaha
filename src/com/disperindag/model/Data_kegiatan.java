/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.model;

/**
 *
 * @author Alvin
 */
public class Data_kegiatan {
    private int id_keg;
    private String keg_usaha_pokok;
    private String keg_usaha_lain;
    private String produk_utama;
    private String produk_lain;
    private double omset_pertahun;
    private double modal_utama;
    private double modal_pinjaman;
    private double total_aset;
    private String karyawanWNI;
    private String karyawanWNA;
    private String totalKaryawan;
    private String kedudukan;
    private String jenis_usaha;
    private double modalDasar;
    private double modalPenempatan;
    private double modalSetor;
    private int    jmlSaham;
    private double nominal;
    private double modalSAktif;
    private double modalSPasif;
    private int sektorUsaha;

    public Data_kegiatan() {
    }

    public Data_kegiatan(int id_keg, String keg_usaha_pokok, String keg_usaha_lain, String produk_utama, String produk_lain, double omset_pertahun, double modal_utama, double modal_pinjaman, double total_aset, String karyawanWNI, String karyawanWNA, String totalKaryawan, String kedudukan, String jenis_usaha, double modalDasar, double modalPenempatan, double modalSetor, int jmlSaham, double nominal, double modalSAktif, double modalSPasif) {
        this.id_keg = id_keg;
        this.keg_usaha_pokok = keg_usaha_pokok;
        this.keg_usaha_lain = keg_usaha_lain;
        this.produk_utama = produk_utama;
        this.produk_lain = produk_lain;
        this.omset_pertahun = omset_pertahun;
        this.modal_utama = modal_utama;
        this.modal_pinjaman = modal_pinjaman;
        this.total_aset = total_aset;
        this.karyawanWNI = karyawanWNI;
        this.karyawanWNA = karyawanWNA;
        this.totalKaryawan = totalKaryawan;
        this.kedudukan = kedudukan;
        this.jenis_usaha = jenis_usaha;
        this.modalDasar = modalDasar;
        this.modalPenempatan = modalPenempatan;
        this.modalSetor = modalSetor;
        this.jmlSaham = jmlSaham;
        this.nominal = nominal;
        this.modalSAktif = modalSAktif;
        this.modalSPasif = modalSPasif;
    }
    
    public int getId_keg() {
        return id_keg;
    }

    public void setId_keg(int id_keg) {
        this.id_keg = id_keg;
    }

    public String getKeg_usaha_pokok() {
        return keg_usaha_pokok;
    }

    public void setKeg_usaha_pokok(String keg_usaha_pokok) {
        this.keg_usaha_pokok = keg_usaha_pokok;
    }

    public String getKeg_usaha_lain() {
        return keg_usaha_lain;
    }

    public void setKeg_usaha_lain(String keg_usaha_lain) {
        this.keg_usaha_lain = keg_usaha_lain;
    }

    public String getProduk_utama() {
        return produk_utama;
    }

    public void setProduk_utama(String produk_utama) {
        this.produk_utama = produk_utama;
    }

    public String getProduk_lain() {
        return produk_lain;
    }

    public void setProduk_lain(String produk_lain) {
        this.produk_lain = produk_lain;
    }

    public double getOmset_pertahun() {
        return omset_pertahun;
    }

    public void setOmset_pertahun(double omset_pertahun) {
        this.omset_pertahun = omset_pertahun;
    }

    public double getModal_utama() {
        return modal_utama;
    }

    public void setModal_utama(double modal_utama) {
        this.modal_utama = modal_utama;
    }

    public double getModal_pinjaman() {
        return modal_pinjaman;
    }

    public void setModal_pinjaman(double modal_pinjaman) {
        this.modal_pinjaman = modal_pinjaman;
    }

    public double getTotal_aset() {
        return total_aset;
    }

    public void setTotal_aset(double total_aset) {
        this.total_aset = total_aset;
    }

    public String getKaryawanWNI() {
        return karyawanWNI;
    }

    public void setKaryawanWNI(String karyawanWNI) {
        this.karyawanWNI = karyawanWNI;
    }

    public String getKaryawanWNA() {
        return karyawanWNA;
    }

    public void setKaryawanWNA(String karyawanWNA) {
        this.karyawanWNA = karyawanWNA;
    }

    public String getTotalKaryawan() {
        return totalKaryawan;
    }

    public void setTotalKaryawan(String totalKaryawan) {
        this.totalKaryawan = totalKaryawan;
    }

    public String getKedudukan() {
        return kedudukan;
    }

    public void setKedudukan(String kedudukan) {
        this.kedudukan = kedudukan;
    }

    public String getJenis_usaha() {
        return jenis_usaha;
    }

    public void setJenis_usaha(String jenis_usaha) {
        this.jenis_usaha = jenis_usaha;
    }

    public double getModalDasar() {
        return modalDasar;
    }

    public void setModalDasar(double modalDasar) {
        this.modalDasar = modalDasar;
    }

    public double getModalPenempatan() {
        return modalPenempatan;
    }

    public void setModalPenempatan(double modalPenempatan) {
        this.modalPenempatan = modalPenempatan;
    }

    public double getModalSetor() {
        return modalSetor;
    }

    public void setModalSetor(double modalSetor) {
        this.modalSetor = modalSetor;
    }

    public int getJmlSaham() {
        return jmlSaham;
    }

    public void setJmlSaham(int jmlSaham) {
        this.jmlSaham = jmlSaham;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public double getModalSAktif() {
        return modalSAktif;
    }

    public void setModalSAktif(double modalSAktif) {
        this.modalSAktif = modalSAktif;
    }

    public double getModalSPasif() {
        return modalSPasif;
    }

    public void setModalSPasif(double modalSPasif) {
        this.modalSPasif = modalSPasif;
    }

    public int getSektorUsaha() {
        return sektorUsaha;
    }

    public void setSektorUsaha(int sektorUsaha) {
        this.sektorUsaha = sektorUsaha;
    }
    
}
