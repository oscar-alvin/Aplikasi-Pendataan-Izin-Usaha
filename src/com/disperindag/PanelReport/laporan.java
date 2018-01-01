/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.PanelReport;

import com.disperindag.koneksi.myConnection;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oscar
 */
public class laporan {
    
    private Connection conn = null;
    private static String file_path = "/com/disperindag/report/";

    public laporan() {
        conn = new myConnection().getConnection();
    }
    
    public void list_perusahaan(String key){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "list_perusahaan.jrxml");

            Map parameters = new HashMap();
            parameters.put("key", Integer.parseInt(key));
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Hurufawal(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "huruf_awal.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("huruf", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Komuditi(String[] kode){
        try {
            File f = new File(file_path + "komuditi.jrxml");
            InputStream is = getClass().getResourceAsStream(file_path + "komuditi.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("jenis_perusahaan", kode[1]);
            parameters.put("produk_utama", kode[2]);
            parameters.put("kedudukanUSH", kode[3]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void KomuditiUtama(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "komuditi_utama.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("jenis_perusahaan", kode[1]);
            parameters.put("komuditi_utama", kode[2]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ModalKegUsaha(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "ModalKeg_Usaha.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",  kode[0]);
            parameters.put("modal_awal", Double.parseDouble(kode[1]));
            parameters.put("modal_akhir", Double.parseDouble(kode[2]));
            parameters.put("jenis_perusahaan", kode[3]);
            parameters.put("kegUsaha", kode[4]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void BentukUsaha(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "bentuk_usaha.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kegUsaha(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "KegUsaha.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
            parameters.put("kegUsaha", kode[2]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kegUsahaPokok(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "KegUsahaPokok.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
            parameters.put("kegUsaha", kode[2]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void PenanamanModal(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "penanaman_modal.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("penanaman_modal", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listKecamatan(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "List_Kecamatan.jrxml");

            Map parameters = new HashMap();
            parameters.put("kecamatan", kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void listKelurahan(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "List_Kabupaten.jrxml");

            Map parameters = new HashMap();
            parameters.put("kelurahan",    kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SektorUsaha(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "sektor_usaha.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten", kode[0]);
            parameters.put("bentuk_usaha", kode[1]);
            parameters.put("sektor_usaha", Integer.parseInt(kode[2]));
            parameters.put("SU", kode[3]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jumlahPerusahaan(){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "jumlah_perusahaan.jrxml");

            Map parameters = new HashMap();
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void laporanBulanan(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "lap_bulanan.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",     kode[0]);
            parameters.put("tanggal", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void masa_laku(String[] kode){
        try {
            InputStream is = getClass().getResourceAsStream(file_path + "massa_laku.jrxml");

            Map parameters = new HashMap();
            parameters.put("kabupaten",kode[0]);
            parameters.put("tanggal", kode[1]);
          
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
