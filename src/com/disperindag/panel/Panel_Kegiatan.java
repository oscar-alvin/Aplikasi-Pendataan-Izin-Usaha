/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.panel;

import com.disperindag.Util.FilterUsahaModel;
import com.disperindag.Util.txtNumber_validator;
import com.disperindag.dao.daoData_kegiatan;
import com.disperindag.dao.daoKegUsaha;
import com.disperindag.dao.daoProduk;
import com.disperindag.model.Data_kegiatan;
import com.disperindag.model.keg_usaha;
import com.disperindag.model.produk;
import com.disperindag.sql.PERUSAHAAN;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class Panel_Kegiatan extends javax.swing.JPanel {

    private Connection con = null;
    private daoData_kegiatan d = null;
    private List<keg_usaha> lk = new daoKegUsaha().getAllUsaha();
    private ArrayList<String> aku = new ArrayList<String>();
    private ArrayList<String> apu = new ArrayList<String>();
    private List<produk> lp = new daoProduk().getAllProduk();
    private int _id;
    private int wni = 0;
    private int wna = 0;
    private int total_karyawan = 0;
    private String usahaPokok;
    private String usahaLain;
    private String ProdukPokok;
    private String ProdukLain;
    private String kedudukan;
    private String jenisUsaha;
    private int sektorUsaha;
    private int currentCaretPosition;

    /**
     * Creates new form Panel_Kegiatan_perush
     */
    public Panel_Kegiatan(Connection con, String jp) {
        initComponents();
        this.con = con;
        d = new daoData_kegiatan(con);
        setComboFilter();
        cekPanel(jp);
        clear();
        panel_pengecer.setVisible(false);
    }

    public void setId(int id) {
        this._id = id;
    }

    private void saveData() throws SQLException {
        try {
            Data_kegiatan dk = new Data_kegiatan();
            dk.setId_keg(_id);
            dk.setKeg_usaha_pokok(usahaPokok);
            dk.setKeg_usaha_lain(usahaLain);
            dk.setProduk_utama(ProdukPokok);
            dk.setProduk_lain(ProdukLain);
            dk.setOmset_pertahun((Double) txt_omset.getValue());
            dk.setModal_utama((Double) txt_modalSendiri.getValue());
            dk.setModal_pinjaman((Double) txt_modalPinjaman.getValue());
            dk.setTotal_aset((Double) txt_totalAset.getValue());
            dk.setKaryawanWNI(txt_karyawanWNI.getText());
            dk.setKaryawanWNA(txt_karyawanWNA.getText());
            dk.setTotalKaryawan(total_karyawan + "");
            dk.setKedudukan(kedudukan);
            dk.setJenis_usaha(jenisUsaha);
            dk.setModalDasar((Double) txt_modalDasar.getValue());
            dk.setModalPenempatan((Double) txt_modalPenempatan.getValue());
            dk.setModalSetor((Double) txt_modalSetor.getValue());
            dk.setJmlSaham((int) jSpinner_jmlsaham.getValue());
            dk.setNominal((Double) txt_nominal.getValue());
            dk.setModalSAktif((Double) txt_modalSAktif.getValue());
            dk.setModalSPasif((Double) txt_modalSPasif.getValue());
            dk.setSektorUsaha(sektorUsaha);
            if (d.updateKegiatan(dk) == true) {
                JOptionPane.showMessageDialog(this, "Data tersimpan");
                clear();
            }
        } catch (NumberFormatException | HeadlessException e) {
            e.printStackTrace();
        }
    }

    public void setKegiatan(Data_kegiatan dk) {
        try {
            combo_usaha_pokok.setSelectedItem(dk.getKeg_usaha_pokok());
            combo_usaha_lain.setSelectedItem(dk.getKeg_usaha_lain());
            combo_produk_utama.setSelectedItem(dk.getProduk_utama());
            combo_produk_lain.setSelectedItem(dk.getProduk_lain());
            txt_omset.setValue(dk.getOmset_pertahun());
            txt_totalAset.setValue(dk.getTotal_aset());
            txt_modalSendiri.setValue(dk.getModal_utama());
            txt_modalPinjaman.setValue(dk.getModal_pinjaman());
            txt_karyawanWNI.setText(dk.getKaryawanWNI());
            txt_karyawanWNA.setText(dk.getKaryawanWNA());
            txt_jumlahKaryawan.setText(dk.getTotalKaryawan());
            combo_kedudukan.setSelectedItem(dk.getKedudukan());
            combo_jenis_usaha.setSelectedItem(dk.getJenis_usaha());
            txt_modalDasar.setValue(dk.getModalDasar());               // 
            txt_modalPenempatan.setValue(dk.getModalPenempatan());
            txt_modalSetor.setValue(dk.getModalSetor());
            jSpinner_jmlsaham.setValue(dk.getJmlSaham());
            txt_nominal.setValue(dk.getNominal());
            txt_modalSAktif.setValue(dk.getModalSAktif());
            txt_modalSPasif.setValue(dk.getModalSPasif());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setComboFilter(){
        for(keg_usaha k : lk){
            aku.add(k.getNama_usaha());
        }
        for(produk p : lp){
            apu.add(p.getUraian());
        }
        new FilterUsahaModel(aku.toArray(), combo_usaha_pokok);
        new FilterUsahaModel(aku.toArray(), combo_usaha_lain);
        new FilterUsahaModel(apu.toArray(), combo_produk_utama);
        new FilterUsahaModel(apu.toArray(), combo_produk_lain);
    }

    private void initCombo() {
        combo_usaha_pokok.removeAllItems();
        combo_usaha_lain.removeAllItems();
        combo_usaha_pokok.addItem("-- Usaha Pokok--");
        combo_usaha_lain.addItem("-- Usaha Lain--");
        for (keg_usaha k : lk) {
            combo_usaha_pokok.addItem(k.getNama_usaha());
            combo_usaha_lain.addItem(k.getNama_usaha());
        }

        combo_produk_utama.removeAllItems();
        combo_produk_lain.removeAllItems();
        for (produk p : lp) {
            combo_produk_utama.addItem(p.getUraian());
            combo_produk_lain.addItem(p.getUraian());
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

        top = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_usaha_pokok = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        combo_usaha_lain = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        combo_produk_utama = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        combo_produk_lain = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_omset = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_totalAset = new javax.swing.JFormattedTextField();
        pnl_modal = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_modalSendiri = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_modalPinjaman = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        combo_kedudukan = new javax.swing.JComboBox();
        panel_pengecer = new javax.swing.JPanel();
        combo_jenis_usaha = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        btn_simpan = new com.disperindag.widget.Button();
        btn_batal = new com.disperindag.widget.Button();
        panel_jumlahKaryawan = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_karyawanWNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_karyawanWNA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_jumlahKaryawan = new javax.swing.JTextField();
        pnl_modalSaham = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_modalDasar = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_modalPenempatan = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_modalSetor = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jSpinner_jmlsaham = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        txt_nominal = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_modalSAktif = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_modalSPasif = new javax.swing.JFormattedTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jenis kegiatan usaha", 0, 0, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setText("Kegiatan usaha pokok");

        combo_usaha_pokok.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_usaha_pokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_usaha_pokokActionPerformed(evt);
            }
        });

        jLabel2.setText("Kegiatan usaha lain");

        combo_usaha_lain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_usaha_lain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_usaha_lainActionPerformed(evt);
            }
        });

        jLabel3.setText("Komuditi / Produk utama");

        combo_produk_utama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_produk_utama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_produk_utamaActionPerformed(evt);
            }
        });

        jLabel4.setText("Komuditi / Produk lain");

        combo_produk_lain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_produk_lain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_produk_lainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_usaha_lain, 0, 444, Short.MAX_VALUE)
                    .addComponent(combo_usaha_pokok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_produk_lain, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_produk_utama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_usaha_pokok, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_usaha_lain, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_produk_utama, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_produk_lain, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 0, 10));

        jLabel5.setText("Omset Perusahaan per tahun");
        jPanel3.add(jLabel5);

        txt_omset.setText("jFormattedTextField1");
        jPanel3.add(txt_omset);

        jLabel8.setText("Total Aset (setelah perusahaan beroperasi)");
        jPanel3.add(jLabel8);

        txt_totalAset.setText("jFormattedTextField1");
        jPanel3.add(txt_totalAset);

        pnl_modal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modal", 0, 0, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnl_modal.setLayout(new java.awt.GridLayout(2, 2, 2, 2));

        jLabel6.setText("Modal sendiri");
        pnl_modal.add(jLabel6);

        txt_modalSendiri.setText("jFormattedTextField1");
        pnl_modal.add(txt_modalSendiri);

        jLabel7.setText("Modal pinjaman");
        pnl_modal.add(jLabel7);

        txt_modalPinjaman.setText("jFormattedTextField1");
        pnl_modal.add(txt_modalPinjaman);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Kedudukan dalam mata rantai kegiatan usaha");

        combo_kedudukan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Produsen", "Sub Distributor", "Eksportir", "Distributor / Wholesaler / Grosir", "Importir", "Pengecer", "Agen" }));
        combo_kedudukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_kedudukanActionPerformed(evt);
            }
        });

        combo_jenis_usaha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Swalayan/supermarket", "Toserba/Department Store", "Toko/kios", "Lainnya" }));
        combo_jenis_usaha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_jenis_usahaActionPerformed(evt);
            }
        });

        jLabel13.setText("Jenis Usaha");

        javax.swing.GroupLayout panel_pengecerLayout = new javax.swing.GroupLayout(panel_pengecer);
        panel_pengecer.setLayout(panel_pengecerLayout);
        panel_pengecerLayout.setHorizontalGroup(
            panel_pengecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pengecerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combo_jenis_usaha, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panel_pengecerLayout.setVerticalGroup(
            panel_pengecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pengecerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_pengecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_jenis_usaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(combo_kedudukan, 0, 260, Short.MAX_VALUE))
                    .addComponent(panel_pengecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_kedudukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_pengecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setText("BERSIHKAN");

        panel_jumlahKaryawan.setBorder(javax.swing.BorderFactory.createTitledBorder("Jumlah Karyawan"));
        panel_jumlahKaryawan.setLayout(new java.awt.GridLayout(1, 6, 2, 2));

        jLabel9.setText("WNI");
        panel_jumlahKaryawan.add(jLabel9);

        txt_karyawanWNI.setText("jTextField1");
        panel_jumlahKaryawan.add(txt_karyawanWNI);

        jLabel10.setText("WNA");
        panel_jumlahKaryawan.add(jLabel10);

        txt_karyawanWNA.setText("jTextField2");
        panel_jumlahKaryawan.add(txt_karyawanWNA);

        jLabel11.setText("Total");
        panel_jumlahKaryawan.add(jLabel11);

        txt_jumlahKaryawan.setText("jTextField1");
        panel_jumlahKaryawan.add(txt_jumlahKaryawan);

        pnl_modalSaham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modal dan Saham", 0, 0, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnl_modalSaham.setLayout(new java.awt.GridLayout(7, 2, 2, 2));

        jLabel14.setText("Modal Dasar");
        pnl_modalSaham.add(jLabel14);

        txt_modalDasar.setText("jFormattedTextField1");
        pnl_modalSaham.add(txt_modalDasar);

        jLabel15.setText("Modal ditempatkan");
        pnl_modalSaham.add(jLabel15);

        txt_modalPenempatan.setText("jFormattedTextField2");
        pnl_modalSaham.add(txt_modalPenempatan);

        jLabel16.setText("Modal disetor");
        pnl_modalSaham.add(jLabel16);

        txt_modalSetor.setText("jFormattedTextField3");
        pnl_modalSaham.add(txt_modalSetor);

        jLabel17.setText("Banyaknya Saham (lembar)");
        pnl_modalSaham.add(jLabel17);

        jSpinner_jmlsaham.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        pnl_modalSaham.add(jSpinner_jmlsaham);

        jLabel18.setText("Nilai Nominal per Saham");
        pnl_modalSaham.add(jLabel18);

        txt_nominal.setText("jFormattedTextField5");
        pnl_modalSaham.add(txt_nominal);

        jLabel19.setText("Modal disetor Sekutu aktif");
        pnl_modalSaham.add(jLabel19);

        txt_modalSAktif.setText("jFormattedTextField6");
        pnl_modalSaham.add(txt_modalSAktif);

        jLabel20.setText("Modal disetor Sekutu Pasif");
        pnl_modalSaham.add(jLabel20);

        txt_modalSPasif.setText("jFormattedTextField7");
        pnl_modalSaham.add(txt_modalSPasif);

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topLayout.createSequentialGroup()
                        .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(topLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(topLayout.createSequentialGroup()
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panel_jumlahKaryawan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pnl_modalSaham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                                .addComponent(pnl_modal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        topLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel5, panel_jumlahKaryawan, pnl_modal, pnl_modalSaham});

        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_modal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_modalSaham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_jumlahKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_batal)
                    .addComponent(btn_simpan))
                .addContainerGap())
        );

        add(top);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_kedudukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_kedudukanActionPerformed
        // TODO add your handling code here:
        if (combo_kedudukan.getSelectedIndex() > -1) {
            kedudukan = combo_kedudukan.getSelectedItem().toString();
            if (combo_kedudukan.getSelectedItem().equals("Produsen")) {
                panel_pengecer.setVisible(true);
            } else {
                panel_pengecer.setVisible(false);
            }
        }
    }//GEN-LAST:event_combo_kedudukanActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            // TODO add your handling code here:
            saveData();
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Kegiatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void combo_usaha_pokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_usaha_pokokActionPerformed
        // TODO add your handling code here:
        if (combo_usaha_pokok.getSelectedIndex() > -1) {
            usahaPokok = combo_usaha_pokok.getSelectedItem().toString();
            for(int a = 0; a<lk.size(); a++){
                if(lk.get(a).getNama_usaha().equalsIgnoreCase(usahaPokok)){
                    sektorUsaha = lk.get(a).getKS();
                }
            }
        }
    }//GEN-LAST:event_combo_usaha_pokokActionPerformed

    private void combo_usaha_lainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_usaha_lainActionPerformed
        // TODO add your handling code here:
        if (combo_usaha_lain.getSelectedIndex() > -1) {
            usahaLain = combo_usaha_lain.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_usaha_lainActionPerformed

    private void combo_produk_utamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_produk_utamaActionPerformed
        // TODO add your handling code here:
        if (combo_produk_utama.getSelectedIndex() > -1) {
            ProdukPokok = combo_produk_utama.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_produk_utamaActionPerformed

    private void combo_produk_lainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_produk_lainActionPerformed
        // TODO add your handling code here:
        if (combo_produk_lain.getSelectedIndex() > -1) {
            ProdukLain = combo_produk_lain.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_produk_lainActionPerformed

    private void combo_jenis_usahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_jenis_usahaActionPerformed
        // TODO add your handling code here:
        if (combo_jenis_usaha.getSelectedIndex() > -1) {
            jenisUsaha = combo_jenis_usaha.getSelectedItem().toString();
        }
    }//GEN-LAST:event_combo_jenis_usahaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox combo_jenis_usaha;
    private javax.swing.JComboBox combo_kedudukan;
    private javax.swing.JComboBox combo_produk_lain;
    private javax.swing.JComboBox combo_produk_utama;
    private javax.swing.JComboBox combo_usaha_lain;
    private javax.swing.JComboBox combo_usaha_pokok;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSpinner jSpinner_jmlsaham;
    private javax.swing.JPanel panel_jumlahKaryawan;
    private javax.swing.JPanel panel_pengecer;
    private javax.swing.JPanel pnl_modal;
    private javax.swing.JPanel pnl_modalSaham;
    private javax.swing.JPanel top;
    private javax.swing.JTextField txt_jumlahKaryawan;
    private javax.swing.JTextField txt_karyawanWNA;
    private javax.swing.JTextField txt_karyawanWNI;
    private javax.swing.JFormattedTextField txt_modalDasar;
    private javax.swing.JFormattedTextField txt_modalPenempatan;
    private javax.swing.JFormattedTextField txt_modalPinjaman;
    private javax.swing.JFormattedTextField txt_modalSAktif;
    private javax.swing.JFormattedTextField txt_modalSPasif;
    private javax.swing.JFormattedTextField txt_modalSendiri;
    private javax.swing.JFormattedTextField txt_modalSetor;
    private javax.swing.JFormattedTextField txt_nominal;
    private javax.swing.JFormattedTextField txt_omset;
    private javax.swing.JFormattedTextField txt_totalAset;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        combo_produk_utama.setSelectedIndex(-1);
        combo_usaha_lain.setSelectedIndex(-1);
        combo_usaha_pokok.setSelectedIndex(-1);
        combo_produk_lain.setSelectedIndex(-1);
        txt_omset.setValue(new Double(0));
        txt_modalSendiri.setValue(new Double(0));
        txt_modalPinjaman.setValue(new Double(0));
        txt_totalAset.setValue(new Double(0));
        txt_karyawanWNI.setText("");
        txt_karyawanWNA.setText("");
        txt_jumlahKaryawan.setText("");
        combo_kedudukan.setSelectedIndex(-1);
        combo_jenis_usaha.setSelectedIndex(-1);
        txt_modalDasar.setValue(new Double(0));
        txt_modalPenempatan.setValue(new Double(0));
        txt_modalSetor.setValue(new Double(0));
        jSpinner_jmlsaham.setValue(0);
        txt_nominal.setValue(new Double(0));
        txt_modalSAktif.setValue(new Double(0));
        txt_modalSPasif.setValue(new Double(0));
    }

    private void setDocument() {
        txt_modalPinjaman.setDocument(new txtNumber_validator());
        txt_modalSendiri.setDocument(new txtNumber_validator());
        txt_omset.setDocument(new txtNumber_validator());
        txt_totalAset.setDocument(new txtNumber_validator());
    }

    private void cekPanel(String jp) {
        if (jp != null) {
            if (jp.equalsIgnoreCase(PERUSAHAAN.KOPERASI)) {
                pnl_modalSaham.setVisible(false);
                pnl_modal.setVisible(true);
            } else if (jp.equalsIgnoreCase(PERUSAHAAN.PT) || jp.equalsIgnoreCase(PERUSAHAAN.PT)
                    || jp.equalsIgnoreCase(PERUSAHAAN.UL) || jp.equalsIgnoreCase(PERUSAHAAN.PO)) {
                pnl_modalSaham.setVisible(true);
                pnl_modal.setVisible(false);
            }
        }
    }
}
