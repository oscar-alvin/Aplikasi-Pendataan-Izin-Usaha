/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.panel;

import com.disperindag.Util.txtNumber_validator;
import com.disperindag.dao.daoData_Umum;
import com.disperindag.dao.daoKabupaten;
import com.disperindag.dao.daoKecamatan;
import com.disperindag.dao.daoKelurahan;
import com.disperindag.dao.daoPropinsi;
import com.disperindag.model.Data_umum;
import com.disperindag.model.kabupaten;
import com.disperindag.model.kecamatan;
import com.disperindag.model.kelurahan;
import com.disperindag.model.propinsi;
import com.disperindag.sql.PERUSAHAAN;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author TOSHIBA
 */
public class Panel_umum extends javax.swing.JPanel {

    private daoData_Umum du = null;
    private Connection con = null;
    List<propinsi> lp = new daoPropinsi().getPropinsi();
    List<kabupaten> lkab = null;
    List<kecamatan> lkec = null;
    List<kelurahan> lkel = null;
    
    private int _id, id_kab;
    private String namaProp, namaKab, namaPropInduk, namaKabInduk, namaKecInduk, namaKelInduk;
    private String status_perusahaan, bentukP, jenisP, penanamanModal;
    private ArrayList<String> kerja_sama = kerja_sama = new ArrayList<String>();
    /**
     * Creates new form Panel_Data_Umum_Perush
     */
    public Panel_umum(Connection con, String jenisPT, boolean edit) {
        initComponents();
        this.con = con;
        du = new daoData_Umum(con);
        cekPanel(jenisPT, edit);
        init_combo_propinsi();
        initProp_Induk();
        initCheckBoxAction(new JCheckBox[]{jCheckBox1, jCheckBox2, jCheckBox3, 
            jCheckBox4, jCheckBox5, jCheckBox6});
//        setDocument();
        clear();
    }
    
    public void setId(int id){
        this._id = id;
    }

    private void init_combo_propinsi(){
        combo_prop.removeAllItems();
        for(propinsi p : lp){
            combo_prop.addItem(p.getNama_prop());
        }
    }
   
    private void init_combo_kabupaten(List<kabupaten> kab){
        combo_kab.removeAllItems();
        for(kabupaten k : kab){
            combo_kab.addItem(k.getNama_kabupaten());
        }
    }
    
    private void simpanDataUmum(){
        try {
            Data_umum d = new Data_umum();
            d.setId_umum(_id);
            d.setNama_kelompok(txt_namaKel.getText());
            d.setLokasi_produksi(txt_lokasi.getText());
            d.setNama_prop(namaProp);
            d.setNama_kab(namaKab);
            d.setJumlah_bank((Integer)jSpinner_jmlBank.getValue());
            d.setNpwp(txt_npwp.getText());
            d.setTgl_berdiri(Date_berdiri.getDate());
            d.setTgl_mulai(Date_mulai.getDate());
            d.setKerja_sama(kerja_sama.toString());
            d.setHak_cipta(txt_hakCipta.getText());
            d.setNo_hak_cipta(txt_noCipta.getText());
            d.setHak_paten(txt_hakPaten.getText());
            d.setNo_hak_paten(txt_noPaten.getText());
            d.setMerek_dagang(txt_merekDagang.getText());
            d.setNo_merek_dagang(txt_noDagang.getText());
            d.setBentuk_koperasi(bentukP);
            d.setJenis_koperasi(jenisP);
            d.setJumlah_anggota(txt_jumlah_anggota.getText());
            
            d.setJangka_Pberdiri((Integer)jSpinner_jangkaBerdiri.getValue());
            d.setStatus_perusahaan(status_perusahaan);
            d.setPenanaman_modal(penanamanModal);
            d.setPerusahaan_induk(txt_namaPInduk.getText());
            d.setTDP_induk(txt_noTDPInduk.getText());
            d.setAlamat_Pinduk(txt_alamatInduk.getText());
            d.setProp_induk(namaPropInduk);
            d.setKab_induk(namaKabInduk);
            d.setKec_induk(namaKecInduk);
            d.setKel_induk(namaKelInduk);
            
            if(du.updateDataUMUM(d) == true){
                JOptionPane.showMessageDialog(this, "Data tersimpan");
                clear();
            }
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }
    }
    
    public void setDataUmum(Data_umum du){
        try {
            txt_namaKel.setText(du.getNama_kelompok());
            txt_lokasi.setText(du.getLokasi_produksi());
            combo_prop.setSelectedItem(du.getNama_prop());
            combo_kab.setSelectedItem(du.getNama_kab());
            jSpinner_jmlBank.setValue(du.getJumlah_bank());
            txt_npwp.setText(du.getNpwp());
            Date_berdiri.setDate(du.getTgl_berdiri());
            Date_mulai.setDate(du.getTgl_mulai());
            loadCheckbox(du.getKerja_sama());
            txt_hakCipta.setText(du.getHak_cipta());
            txt_hakPaten.setText(du.getHak_paten());
            txt_merekDagang.setText(du.getMerek_dagang());
            txt_noCipta.setText(du.getNo_hak_cipta());
            txt_noPaten.setText(du.getNo_hak_paten());
            txt_noDagang.setText(du.getNo_merek_dagang());
            combo_btk_koperasi.setSelectedItem(du.getBentuk_koperasi());
            combo_jenis_koperasi.setSelectedItem(du.getJenis_koperasi());
            txt_jumlah_anggota.setText(du.getJumlah_anggota());
            jSpinner_jangkaBerdiri.setValue(0);
            combo_statusPerusahaan.setSelectedItem(du.getStatus_perusahaan());
            combo_penanamanModal.setSelectedItem(du.getPenanaman_modal());
            txt_namaPInduk.setText(du.getPerusahaan_induk());
            txt_noTDPInduk.setText(du.getTDP_induk());
            txt_alamatInduk.setText(du.getAlamat_Pinduk());
            combo_propInduk.setSelectedItem(du.getProp_induk());
            combo_kabInduk.setSelectedItem(du.getKab_induk());
            combo_kecInduk.setSelectedItem(du.getKec_induk());
            combo_kelInduk.setSelectedItem(du.getKel_induk());
            
        } catch (Exception e) {e.printStackTrace();
        }        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        combo_prop = new javax.swing.JComboBox();
        txt_namaKel = new javax.swing.JTextField();
        txt_npwp = new javax.swing.JTextField();
        txt_lokasi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_kab = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Date_berdiri = new com.toedter.calendar.JDateChooser();
        Date_mulai = new com.toedter.calendar.JDateChooser();
        jSpinner_jmlBank = new javax.swing.JSpinner();
        panel_tambahan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        combo_statusPerusahaan = new javax.swing.JComboBox();
        panel_status = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_namaPInduk = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_noTDPInduk = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamatInduk = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        combo_propInduk = new javax.swing.JComboBox();
        combo_kabInduk = new javax.swing.JComboBox();
        combo_kecInduk = new javax.swing.JComboBox();
        combo_kelInduk = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        combo_penanamanModal = new javax.swing.JComboBox();
        jSpinner_jangkaBerdiri = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        panel_kiri = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        panel_kanan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        combo_btk_koperasi = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        combo_jenis_koperasi = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        txt_jumlah_anggota = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_hakPaten = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_merekDagang = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_noPaten = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_noDagang = new javax.swing.JTextField();
        txt_noCipta = new javax.swing.JTextField();
        txt_hakCipta = new javax.swing.JTextField();
        btn_simpan = new com.disperindag.widget.Button();
        btn_clear = new com.disperindag.widget.Button();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_prop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --", "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_prop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_propActionPerformed(evt);
            }
        });

        jLabel5.setText("NPWP");

        jLabel4.setText("Kab/Kota/Kodya");

        jLabel3.setText("Propinsi");

        combo_kab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --", "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_kab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_kabActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Kelompok Perusahaan/Group");

        jLabel8.setText("Jumlah Bank Nasabah");

        jLabel2.setText("Lokasi Unit Produksi");

        jLabel9.setText("Tanggal Pendirian");

        jLabel10.setText("Tanggal mulai Kegiatan");

        Date_berdiri.setDateFormatString("dd - MMM - yyyy");

        Date_mulai.setDateFormatString("dd - MMM - yyyy");

        jSpinner_jmlBank.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Date_berdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_jmlBank, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Date_mulai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_npwp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_namaKel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(combo_prop, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combo_kab, 0, 160, Short.MAX_VALUE))))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Date_berdiri, combo_prop});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_kab, txt_npwp});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_lokasi, txt_namaKel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namaKel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_prop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(txt_npwp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_jmlBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(Date_berdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date_mulai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(265, 265, 265))
        );

        panel_tambahan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Status Perusahaan");

        combo_statusPerusahaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih --", "Kantor Tunggal", "Kantor Pusat", "Kantor Cabang", "Kantor Pembantu", "Perwakilan" }));
        combo_statusPerusahaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_statusPerusahaanItemStateChanged(evt);
            }
        });

        jLabel19.setText("Nama Perusahaan Induk");

        txt_namaPInduk.setText("jTextField1");

        jLabel20.setText("Nomor TDP");

        try {
            txt_noTDPInduk.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.#.##.#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setText("Alamat Perusahaan");

        txt_alamatInduk.setColumns(20);
        txt_alamatInduk.setRows(5);
        jScrollPane1.setViewportView(txt_alamatInduk);

        jLabel22.setText("Propinsi");

        jLabel23.setText("Kabupaten");

        jLabel24.setText("Kecamatan");

        jLabel25.setText("Kelurahan");

        combo_propInduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_propInduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_propIndukItemStateChanged(evt);
            }
        });

        combo_kabInduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_kabInduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kabIndukItemStateChanged(evt);
            }
        });

        combo_kecInduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_kecInduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kecIndukItemStateChanged(evt);
            }
        });

        combo_kelInduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_kelInduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kelIndukItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel_statusLayout = new javax.swing.GroupLayout(panel_status);
        panel_status.setLayout(panel_statusLayout);
        panel_statusLayout.setHorizontalGroup(
            panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24))
                .addGap(33, 33, 33)
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_statusLayout.createSequentialGroup()
                        .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_propInduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_kecInduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_kabInduk, 0, 161, Short.MAX_VALUE)
                            .addComponent(combo_kelInduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txt_namaPInduk)
                    .addComponent(txt_noTDPInduk)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panel_statusLayout.setVerticalGroup(
            panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_namaPInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_noTDPInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(combo_propInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_kabInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)))
                .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_statusLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24))
                    .addGroup(panel_statusLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_kelInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGroup(panel_statusLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(combo_kecInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setText("Jangka waktu berdiri perusahaan");

        jLabel27.setText("Tahun");

        jLabel28.setText("Bentuk Penanaman Modal");

        combo_penanamanModal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih --", "PMA", "PMDN", "Lainnya" }));
        combo_penanamanModal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_penanamanModalActionPerformed(evt);
            }
        });

        jSpinner_jangkaBerdiri.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout panel_tambahanLayout = new javax.swing.GroupLayout(panel_tambahan);
        panel_tambahan.setLayout(panel_tambahanLayout);
        panel_tambahanLayout.setHorizontalGroup(
            panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tambahanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_tambahanLayout.createSequentialGroup()
                        .addGroup(panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_tambahanLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(40, 40, 40))
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(10, 10, 10)
                        .addGroup(panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(combo_penanamanModal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_tambahanLayout.createSequentialGroup()
                                .addComponent(jSpinner_jangkaBerdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_statusPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel_tambahanLayout.setVerticalGroup(
            panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tambahanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel11)
                    .addComponent(combo_statusPerusahaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_jangkaBerdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_tambahanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(combo_penanamanModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_status, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        panel_kiri.setBorder(javax.swing.BorderFactory.createTitledBorder("Bentuk Kerja Sama dengan pihak ketiga"));
        panel_kiri.setLayout(new java.awt.GridLayout(3, 2));

        jCheckBox1.setText("Jaringan Intenasional");
        panel_kiri.add(jCheckBox1);

        jCheckBox2.setText("Jaringan Nasional");
        panel_kiri.add(jCheckBox2);

        jCheckBox3.setText("Waralaba Internasional");
        panel_kiri.add(jCheckBox3);

        jCheckBox4.setText("Waralaba Nasional");
        panel_kiri.add(jCheckBox4);

        jCheckBox5.setText("KSO");
        panel_kiri.add(jCheckBox5);

        jCheckBox6.setText("Mandiri");
        panel_kiri.add(jCheckBox6);

        jPanel5.add(panel_kiri);

        panel_kanan.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Khusus Koperasi"));
        panel_kanan.setLayout(new java.awt.GridLayout(3, 2));

        jLabel6.setText("Bentuk koperasi");
        panel_kanan.add(jLabel6);

        combo_btk_koperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih --", "Primer", "Sekunder" }));
        combo_btk_koperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_btk_koperasiActionPerformed(evt);
            }
        });
        panel_kanan.add(combo_btk_koperasi);

        jLabel7.setText("Jenis Koperasi");
        panel_kanan.add(jLabel7);

        combo_jenis_koperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih --", "Simpan pinjam", "konsumen", "produsen", "pemasaran", "jasa", "lainnya" }));
        combo_jenis_koperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_jenis_koperasiActionPerformed(evt);
            }
        });
        panel_kanan.add(combo_jenis_koperasi);

        jLabel18.setText("Jumlah Anggota");
        panel_kanan.add(jLabel18);
        panel_kanan.add(txt_jumlah_anggota);

        jPanel5.add(panel_kanan);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("Pemegang hak cipta");

        jLabel13.setText("Pemegang hak paten");

        jLabel12.setText("Merek Dagang");

        jLabel17.setText("No");

        jLabel15.setText("No");

        jLabel16.setText("No");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_hakPaten, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(txt_merekDagang)
                    .addComponent(txt_hakCipta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_noCipta, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(txt_noPaten)
                    .addComponent(txt_noDagang))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel16, jLabel17});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_merekDagang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txt_noCipta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hakPaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_noPaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hakCipta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txt_noDagang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_clear.setText("BERSIHKAN");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_tambahan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_tambahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_clear))
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_propActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_propActionPerformed
        // TODO add your handling code here:
        if(combo_prop.getSelectedIndex() > -1){
            int kode = lp.get( (combo_prop.getSelectedIndex())).getId_prop();
            lkab = new daoKabupaten().getKabupatenByid(kode);
            init_combo_kabupaten(lkab);
            namaProp = combo_prop.getSelectedItem().toString();
        }else {
            combo_kab.removeAllItems();
        }
    }//GEN-LAST:event_combo_propActionPerformed

    private void combo_kabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_kabActionPerformed
        // TODO add your handling code here:
        if(combo_kab.getSelectedIndex() > -1){
//            int kode = lkab.get( (combo_kab.getSelectedIndex())-1).getKode_kab();
//            lkec = new daoKecamatan().getKecamatanByid(kode);
//            init_combo_kecamatan(lkec);
            namaKab = combo_kab.getSelectedItem().toString();
        }else {
            combo_kecInduk.removeAllItems();
            combo_kelInduk.removeAllItems();
        }
    }//GEN-LAST:event_combo_kabActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        simpanDataUmum();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void combo_propIndukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_propIndukItemStateChanged
        // TODO add your handling code here:
        if(combo_propInduk.getSelectedIndex() > -1){
            int kode = lp.get( (combo_propInduk.getSelectedIndex())).getId_prop();
            lkab = new daoKabupaten().getKabupatenByid(kode);
            initKab_Induk(lkab);
            namaPropInduk = combo_propInduk.getSelectedItem().toString();
        }else {
            combo_kabInduk.removeAllItems();
            combo_kecInduk.removeAllItems();
            combo_kelInduk.removeAllItems();
        }
    }//GEN-LAST:event_combo_propIndukItemStateChanged

    private void combo_kabIndukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kabIndukItemStateChanged
        // TODO add your handling code here:
        if(combo_kabInduk.getSelectedIndex() > -1){
            int kode = lkab.get( (combo_kabInduk.getSelectedIndex())).getKode_kab();
            lkec = new daoKecamatan().getKecamatanByid(kode);
            initKec_Induk(lkec);
            namaKabInduk = combo_kabInduk.getSelectedItem().toString();
        }else {
            combo_kecInduk.removeAllItems();
            combo_kelInduk.removeAllItems();
        }
    }//GEN-LAST:event_combo_kabIndukItemStateChanged

    private void combo_kecIndukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kecIndukItemStateChanged
        // TODO add your handling code here:
        if(combo_kecInduk.getSelectedIndex() > -1){
            int kode = lkec.get( (combo_kecInduk.getSelectedIndex())).getKode_kec();
            lkel = new daoKelurahan().getKelurahanByid(kode);
            initKel_Induk(lkel);
            namaKecInduk = combo_kecInduk.getSelectedItem().toString();
        }else {
            combo_kelInduk.removeAllItems();
        }
    }//GEN-LAST:event_combo_kecIndukItemStateChanged

    private void combo_kelIndukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kelIndukItemStateChanged
        // TODO add your handling code here:
        if(combo_kelInduk.getSelectedIndex() > -1){
            namaKelInduk = combo_kelInduk.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_kelIndukItemStateChanged

    private void combo_statusPerusahaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_statusPerusahaanItemStateChanged
        // TODO add your handling code here:
            if(combo_statusPerusahaan.getSelectedIndex() > 0 ){
                status_perusahaan = combo_statusPerusahaan.getSelectedItem().toString();
                if(combo_statusPerusahaan.getSelectedIndex() > 2){
                    panel_status.setVisible(true);
                }else {
                    panel_status.setVisible(false);
                }
            }else {
                panel_status.setVisible(false);
            }
    }//GEN-LAST:event_combo_statusPerusahaanItemStateChanged

    private void combo_btk_koperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_btk_koperasiActionPerformed
        // TODO add your handling code here:
        if(combo_btk_koperasi.getSelectedIndex() > -1){
            bentukP = combo_btk_koperasi.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_btk_koperasiActionPerformed

    private void combo_jenis_koperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_jenis_koperasiActionPerformed
        // TODO add your handling code here:
        if(combo_jenis_koperasi.getSelectedIndex() > -1){
            jenisP = combo_jenis_koperasi.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_jenis_koperasiActionPerformed

    private void combo_penanamanModalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_penanamanModalActionPerformed
        // TODO add your handling code here:
        if(combo_penanamanModal.getSelectedIndex() > 0){
            penanamanModal = combo_penanamanModal.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_penanamanModalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_berdiri;
    private com.toedter.calendar.JDateChooser Date_mulai;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox combo_btk_koperasi;
    private javax.swing.JComboBox combo_jenis_koperasi;
    private javax.swing.JComboBox combo_kab;
    private javax.swing.JComboBox combo_kabInduk;
    private javax.swing.JComboBox combo_kecInduk;
    private javax.swing.JComboBox combo_kelInduk;
    private javax.swing.JComboBox combo_penanamanModal;
    private javax.swing.JComboBox combo_prop;
    private javax.swing.JComboBox combo_propInduk;
    private javax.swing.JComboBox combo_statusPerusahaan;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_jangkaBerdiri;
    private javax.swing.JSpinner jSpinner_jmlBank;
    private javax.swing.JPanel panel_kanan;
    private javax.swing.JPanel panel_kiri;
    private javax.swing.JPanel panel_status;
    private javax.swing.JPanel panel_tambahan;
    private javax.swing.JTextArea txt_alamatInduk;
    private javax.swing.JTextField txt_hakCipta;
    private javax.swing.JTextField txt_hakPaten;
    private javax.swing.JTextField txt_jumlah_anggota;
    private javax.swing.JTextField txt_lokasi;
    private javax.swing.JTextField txt_merekDagang;
    private javax.swing.JTextField txt_namaKel;
    private javax.swing.JTextField txt_namaPInduk;
    private javax.swing.JTextField txt_noCipta;
    private javax.swing.JTextField txt_noDagang;
    private javax.swing.JTextField txt_noPaten;
    private javax.swing.JFormattedTextField txt_noTDPInduk;
    private javax.swing.JTextField txt_npwp;
    // End of variables declaration//GEN-END:variables
        
    private void loadCheckbox(String kerja_sama){
        if( kerja_sama != null )
        {
            if(kerja_sama.contains(jCheckBox1.getText())){
                jCheckBox1.setSelected(true);
                
            }if(kerja_sama.contains(jCheckBox2.getText())){
                jCheckBox2.setSelected(true);
                
            } if(kerja_sama.contains(jCheckBox3.getText())){
                jCheckBox3.setSelected(true);
                
            } if(kerja_sama.contains(jCheckBox4.getText())){
                jCheckBox4.setSelected(true);
                
            } if(kerja_sama.contains(jCheckBox5.getText())){
                jCheckBox5.setSelected(true);
                
            } if(kerja_sama.contains(jCheckBox6.getText())){
                jCheckBox6.setSelected(true);
            }
        }
    }
        
    private void cekPanel(String jp, boolean b){
        if(jp != null){
            if(jp.equalsIgnoreCase(PERUSAHAAN.KOPERASI)){
                panel_tambahan.setVisible(false);
            }else if(jp.equalsIgnoreCase(PERUSAHAAN.PT) || jp.equalsIgnoreCase(PERUSAHAAN.CV) 
                    || jp.equalsIgnoreCase(PERUSAHAAN.UL) || jp.equalsIgnoreCase(PERUSAHAAN.PO)){
                panel_tambahan.setVisible(true);
            }
        }
    }
    
    private void setDocument(){
        txt_noCipta.setDocument(new txtNumber_validator());
        txt_noDagang.setDocument(new txtNumber_validator());
        txt_noPaten.setDocument(new txtNumber_validator());
        txt_npwp.setDocument(new txtNumber_validator());
        txt_jumlah_anggota.setDocument(new txtNumber_validator());
    }

    private void clear(){
        this.clearText(new JTextField[]{txt_namaKel,txt_lokasi, txt_npwp, txt_hakCipta, txt_hakPaten, txt_merekDagang, 
            txt_noCipta, txt_noPaten, txt_noDagang, txt_jumlah_anggota, txt_namaPInduk, txt_noTDPInduk} );
        this.unselectCheckbox(new JCheckBox[] {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6});
        combo_prop.setSelectedIndex(-1);
        Date_berdiri.setDate(null);
        Date_mulai.setDate(null);
        combo_btk_koperasi.setSelectedIndex(-1);
        combo_statusPerusahaan.setSelectedIndex(-1);
        combo_penanamanModal.setSelectedIndex(-1);
        txt_alamatInduk.setText("");
        combo_propInduk.setSelectedIndex(-1);
    }
    
    private void clearText(JTextField[] text){
        for (JTextField jTextField : text) {
            jTextField.setText("");
        }
    }
    private void unselectCheckbox(JCheckBox[] check){
        for (JCheckBox jCheckBox : check) {
            jCheckBox.setSelected(false);
        }
    }
    
    private void initCheckBoxAction(JCheckBox[] j){
        for (JCheckBox jCheckBox : j) {
            jCheckBox.addItemListener(new CheckBoxAction());
        }
    }
    
    class CheckBoxAction implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getItem() == jCheckBox1){
            if (e.getStateChange() == ItemEvent.SELECTED) {
                kerja_sama.add( jCheckBox1.getText() );
            } else {
                kerja_sama.remove( jCheckBox1.getText() );
            }
            }else if(e.getItem() == jCheckBox2){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kerja_sama.add( jCheckBox2.getText() );
                } else {
                    kerja_sama.remove( jCheckBox2.getText() );
                }
            }else if(e.getItem() == jCheckBox3){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kerja_sama.add( jCheckBox3.getText() );
                } else {
                    kerja_sama.remove( jCheckBox3.getText() );
                }
            }else if(e.getItem() == jCheckBox4){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kerja_sama.add( jCheckBox4.getText() );
                } else {
                    kerja_sama.remove( jCheckBox4.getText() );
                }
            }else if(e.getItem() == jCheckBox5){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kerja_sama.add( jCheckBox5.getText() );
                } else {
                    kerja_sama.remove( jCheckBox5.getText() );
                }
            }else if(e.getItem() == jCheckBox6){
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kerja_sama.add( jCheckBox6.getText() );
                } else {
                    kerja_sama.remove( jCheckBox6.getText() );
                }
            }
        }
    }
    
    private void initProp_Induk(){
        combo_propInduk.removeAllItems();
        for(propinsi p : lp){
            combo_propInduk.addItem(p.getNama_prop());
        }
    }
   
    private void initKab_Induk(List<kabupaten> kab){
        combo_kabInduk.removeAllItems();
        for(kabupaten k : kab){
            combo_kabInduk.addItem(k.getNama_kabupaten());
        }
    }
    
    private void initKec_Induk(List<kecamatan> kec){
        combo_kecInduk.removeAllItems();
        combo_kecInduk.addItem("- Pilih -");
        for(kecamatan k : kec){
            combo_kecInduk.addItem(k.getNama_kecamatan());
        }
    }
    
    private void initKel_Induk(List<kelurahan> kel){
        combo_kelInduk.removeAllItems();
        combo_kelInduk.addItem("- Pilih -");
        for(kelurahan k : kel){
            combo_kelInduk.addItem(k.getNama_kelurahan());
        }
    }
}
