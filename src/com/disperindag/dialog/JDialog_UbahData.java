/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dialog;

import com.disperindag.dao.daoData_Legalitas;
import com.disperindag.dao.daoData_Lokasi;
import com.disperindag.dao.daoData_Master;
import com.disperindag.dao.daoData_Umum;
import com.disperindag.dao.daoData_kegiatan;
import com.disperindag.dao.daoData_pemilik;
import com.disperindag.model.Data_kegiatan;
import com.disperindag.model.Data_legalitas;
import com.disperindag.model.Data_lokasi;
import com.disperindag.model.Data_pemilik;
import com.disperindag.model.Data_umum;
import com.disperindag.model.Master;
import com.disperindag.panel.Panel_KategoriP;
import com.disperindag.panel.Panel_Kegiatan;
import com.disperindag.panel.Panel_Legalitas;
import com.disperindag.panel.Panel_Lokasi;
import com.disperindag.panel.Panel_Pemilik;
import com.disperindag.panel.Panel_Pimpinan;
import com.disperindag.panel.Panel_Saham;
import com.disperindag.panel.Panel_umum;
import com.disperindag.sql.PERUSAHAAN;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Alvin
 */
public class JDialog_UbahData extends javax.swing.JDialog {

    private Panel_Pemilik panel1 = null;
    private Panel_Lokasi panel2 = null;
    private Panel_umum panel3 = null;
    private Panel_Legalitas panel4 = null;
    private Panel_Pimpinan panel5 = null;
    private Panel_Kegiatan panel6 = null;
    private Panel_Saham panel7 = null;
    private Panel_KategoriP panel8 = null;
    private Master mk;
    private Data_pemilik p;
    private Data_lokasi l;
    private Data_umum du;
    private Data_legalitas leg;
    private Data_kegiatan dk;
    private Connection con;
    private String jenis_PT = "";
    private int kode_data;
    private int ID_DATA;

    /**
     * Creates new form JDialog_UbahData
     */
    public JDialog_UbahData(java.awt.Frame parent, boolean modal, Master mk, Connection con, String jenis_PT) {
        super(parent, modal);
        initComponents();
        setSize(1000, 700);
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        this.mk = mk;
        this.kode_data = mk.getId_master();
        this.con = con;
        this.jenis_PT = jenis_PT;
        txt_kodeData.setEditable(false);
        loadAllData();
        init_tabb();
        initData();
    }

    public final void init_tabb() {

        panel1 = new Panel_Pemilik(con);
        panel2 = new Panel_Lokasi(con);
        panel3 = new Panel_umum(con, jenis_PT, false);
        panel4 = new Panel_Legalitas(con, jenis_PT, false);
        panel5 = new Panel_Pimpinan(con);
        panel6 = new Panel_Kegiatan(con, jenis_PT);
        panel7 = new Panel_Saham(con, jenis_PT);
        panel8 = new Panel_KategoriP(con, jenis_PT);

        tab_data.addTab("DATA PEMILIK", new JScrollPane(panel1));
        tab_data.addTab("DATA LOKASI", new JScrollPane(panel2));
        tab_data.addTab("DATA UMUM", new JScrollPane(panel3));
        tab_data.addTab("LEGALITAS", new JScrollPane(panel4));
        tab_data.addTab("DATA PIMPINAN", new JScrollPane(panel5));
        tab_data.addTab("DATA KEGIATAN", new JScrollPane(panel6));
        if (jenis_PT.equalsIgnoreCase(PERUSAHAAN.PT) || jenis_PT.equalsIgnoreCase(PERUSAHAAN.CV)
                || jenis_PT.equalsIgnoreCase(PERUSAHAAN.PO)) {
            tab_data.addTab("DATA SAHAM", new JScrollPane(panel7));
        }
        if (jenis_PT.equalsIgnoreCase(PERUSAHAAN.PT) || jenis_PT.equalsIgnoreCase(PERUSAHAAN.CV)
                || jenis_PT.equalsIgnoreCase(PERUSAHAAN.UL) || jenis_PT.equalsIgnoreCase(PERUSAHAAN.PO)) {
            tab_data.add("KATEGORI PERUSAHAAN", new JScrollPane(panel8));
        }
    }

    private void loadAllData() {
        p = new daoData_pemilik(con).getPemilik(kode_data);
        l = new daoData_Lokasi(con).getLokasi(kode_data);
        du = new daoData_Umum(con).getDU(kode_data);
        leg = new daoData_Legalitas(con).getLegalitas(kode_data);
        dk = new daoData_kegiatan(con).getKegiatan(kode_data);
    }

    private void saveData() {
        String no_tdp = null;

        if (txt_noTDP.getValue() != null) {
            no_tdp = txt_noTDP.getText();
        }

        if (!(txt_kodeData.getText().equals("")) & combo_jenis_pendaftaran.getSelectedIndex() > -1) {
            Master mk = new Master();
            mk.setId_master(Integer.parseInt(txt_kodeData.getText()));
            mk.setNo_tdp(no_tdp);
            mk.setTgl_regis(new Date());
            mk.setJenis_regis(combo_jenis_pendaftaran.getSelectedItem().toString());
            mk.setNo_pembaharuan((Integer) jSpinner_noPembaharuan.getValue());
            mk.setJenis_perusahaan(jenis_PT);

            try {
                if (new daoData_Master(con).updateMaster(mk) == true) {
                    txt_kodeData.setEditable(false);
                    txt_noTDP.setEditable(false);
                    combo_jenis_pendaftaran.setEditable(false);
                    jSpinner_noPembaharuan.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDialog_UbahData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kode Data tidak boleh kosong");
        }
    }

    private void initData() {

        if (mk != null && p != null && l != null && du != null && leg != null && dk != null) {
            txt_kodeData.setText(mk.getId_master() + "");
            txt_noTDP.setText(mk.getNo_tdp());
            combo_jenis_pendaftaran.setSelectedItem(mk.getJenis_regis());
            jSpinner_noPembaharuan.setValue(mk.getNo_pembaharuan());

            panel1.setId(kode_data);
            panel2.setId(kode_data);
            panel3.setId(kode_data);
            panel4.setId(kode_data);
            panel5.setId(kode_data);
            panel6.setId(kode_data);
            panel7.setId(kode_data);
            panel8.setId(kode_data);

            panel1.setPemilik(p);
            panel2.setLokasi(l);
            panel3.setDataUmum(du);
            panel4.setLegalitas(leg);
            panel6.setKegiatan(dk);
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
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_kodeData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combo_jenis_pendaftaran = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_noTDP = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jSpinner_noPembaharuan = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        btn_save = new com.disperindag.widget.Button();
        jPanel4 = new javax.swing.JPanel();
        tab_data = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FORM PENDAFTARAN PERIZINAN KOPERASI, PT, CV DAN BENTUK USAHA LAIN");
        jPanel2.add(jLabel5);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setLayout(new java.awt.GridLayout(2, 3, 5, 5));

        jLabel6.setText("Kode Data");
        jPanel6.add(jLabel6);
        jPanel6.add(txt_kodeData);

        jLabel7.setText("Jenis Permintaan Pendaftaran");
        jPanel6.add(jLabel7);

        combo_jenis_pendaftaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih --", "Baru", "Pembaharuan / perpanjangan", "perubahan" }));
        combo_jenis_pendaftaran.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_jenis_pendaftaranItemStateChanged(evt);
            }
        });
        jPanel6.add(combo_jenis_pendaftaran);

        jLabel8.setText("NO. TDP");
        jPanel6.add(jLabel8);

        try{
            txt_noTDP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.#.##.#####")));
        }catch(java.text.ParseException ex){
            ex.printStackTrace();
        }
        jPanel6.add(txt_noTDP);

        jLabel9.setText("Pembaharuan / Perpanjangan ke ");
        jPanel6.add(jLabel9);

        jSpinner_noPembaharuan.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jPanel6.add(jSpinner_noPembaharuan);

        jPanel5.add(jPanel6);

        btn_save.setText("SIMPAN");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_save)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.BorderLayout());

        tab_data.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jPanel4.add(tab_data, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_jenis_pendaftaranItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_jenis_pendaftaranItemStateChanged
        // TODO add your handling code here:
        if (combo_jenis_pendaftaran.getSelectedIndex() == 2) {
            jSpinner_noPembaharuan.setEnabled(true);
        } else {
            jSpinner_noPembaharuan.setEnabled(false);
        }
    }//GEN-LAST:event_combo_jenis_pendaftaranItemStateChanged

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btn_saveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox combo_jenis_pendaftaran;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSpinner jSpinner_noPembaharuan;
    private javax.swing.JTabbedPane tab_data;
    private javax.swing.JTextField txt_kodeData;
    private javax.swing.JFormattedTextField txt_noTDP;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        txt_kodeData.setText("");
        txt_noTDP.setText("");
        combo_jenis_pendaftaran.setSelectedIndex(-1);
        jSpinner_noPembaharuan.setEnabled(false);
    }
}
