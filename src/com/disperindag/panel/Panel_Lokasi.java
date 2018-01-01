/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.panel;

import com.disperindag.Util.txtNumber_validator;
import com.disperindag.dao.daoData_Lokasi;
import com.disperindag.dao.daoKabupaten;
import com.disperindag.dao.daoKecamatan;
import com.disperindag.dao.daoKelurahan;
import com.disperindag.dao.daoPropinsi;
import com.disperindag.model.Data_lokasi;
import com.disperindag.model.kabupaten;
import com.disperindag.model.kecamatan;
import com.disperindag.model.kelurahan;
import com.disperindag.model.propinsi;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class Panel_Lokasi extends javax.swing.JPanel {

    private daoData_Lokasi dl = null;
    private Connection con = null;
    private List<propinsi> lp = new daoPropinsi().getPropinsi();
    private List<kabupaten> lkab = null;
    private List<kecamatan> lkec = null;
    private List<kelurahan> lkel = null;
    
    private int _id;
    private String namaProp = "";
    private String namaKab  = "";
    private String namaKec  = "";
    private String namaKel  = "";
    /**
     * Creates new form Panel_Lokasi_Perusahaan
     */
    public Panel_Lokasi(Connection con) {
        initComponents();
        this.con = con;
        dl = new daoData_Lokasi(con);
        init_combo_propinsi();
//        setDocument();
    }
    
    public void setId(int id){
        this._id = id;
    }
    
    private void init_combo_propinsi(){
        combo_prop.removeAllItems();
        combo_prop.addItem("- Pilih -");
        for(propinsi p : lp){
            combo_prop.addItem(p.getNama_prop());
        }
    }
   
    private void init_combo_kabupaten(List<kabupaten> kab){
        combo_kab.removeAllItems();
        combo_kab.addItem("- Pilih -");
        for(kabupaten k : kab){
            combo_kab.addItem(k.getNama_kabupaten());
        }
    }
    
    private void init_combo_kecamatan(List<kecamatan> kec){
        combo_kec.removeAllItems();
        combo_kec.addItem("- Pilih -");
        for(kecamatan k : kec){
            combo_kec.addItem(k.getNama_kecamatan());
        }
    }
    
    private void init_combo_kelurahan(List<kelurahan> kel){
        combo_kel.removeAllItems();
        combo_kel.addItem("- Pilih -");
        for(kelurahan k : kel){
            combo_kel.addItem(k.getNama_kelurahan());
        }
    }
    
    public void setLokasi(Data_lokasi l){
        try{
            txt_namaPerush.setText(l.getNama_perusahaan());
            txt_alamatPerush.setText(l.getAlamat_perusahaan());
            combo_prop.setSelectedItem(l.getNama_prop());
            combo_kab.setSelectedItem(l.getNama_kab());
            combo_kec.setSelectedItem(l.getNama_kec());
            combo_kel.setSelectedItem(l.getNama_kel());
            txt_kodepos.setText(l.getKode_pos());
            txt_noTlp.setText(l.getNo_tlp());
            txt_fax.setText(l.getFax());
            txt_email.setText(l.getEmail());
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    private void clear(){
        txt_namaPerush.setText("");
        txt_alamatPerush.setText("");
        combo_prop.setSelectedIndex(0);
        txt_kodepos.setText("");
        txt_noTlp.setText("");
        txt_fax.setText("");
        txt_email.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamatPerush = new javax.swing.JTextArea();
        txt_namaPerush = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_noTlp = new javax.swing.JTextField();
        combo_prop = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_kodepos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_fax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_kec = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo_kab = new javax.swing.JComboBox();
        combo_kel = new javax.swing.JComboBox();
        btn_clear = new com.disperindag.widget.Button();
        btn_simpan = new com.disperindag.widget.Button();

        txt_alamatPerush.setColumns(20);
        txt_alamatPerush.setRows(3);
        jScrollPane1.setViewportView(txt_alamatPerush);

        jLabel2.setText("Alamat Perusahaan");

        jLabel1.setText("Nama Perusahaan");

        combo_prop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --" }));
        combo_prop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_propItemStateChanged(evt);
            }
        });

        jLabel3.setText("Propinsi");

        jLabel7.setText("Kode Pos");

        jLabel6.setText("Kelurahan");

        jLabel8.setText("No Tlp");

        jLabel9.setText("Fax");

        jLabel5.setText("Kecamatan");

        combo_kec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --" }));
        combo_kec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kecItemStateChanged(evt);
            }
        });

        jLabel10.setText("Email");

        jLabel4.setText("Kabupaten");

        combo_kab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --" }));
        combo_kab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kabItemStateChanged(evt);
            }
        });

        combo_kel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- - --" }));
        combo_kel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_kelItemStateChanged(evt);
            }
        });
        combo_kel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_kelActionPerformed(evt);
            }
        });

        btn_clear.setText("BERSIHKAN");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namaPerush, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_prop, 0, 138, Short.MAX_VALUE)
                            .addComponent(combo_kec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_kab, 0, 140, Short.MAX_VALUE)
                            .addComponent(combo_kel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txt_kodepos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_noTlp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_kec, combo_prop});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_kab, combo_kel});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, txt_email, txt_fax, txt_kodepos, txt_namaPerush, txt_noTlp});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_namaPerush, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_prop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_kec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_kel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kodepos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_noTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_clear))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(container);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        Data_lokasi l = null;
        try{
            l = new Data_lokasi();
            l.setId_lokasi(_id);
            l.setNama_perusahaan(txt_namaPerush.getText());
            l.setAlamat_perusahaan(txt_alamatPerush.getText());
            l.setNama_prop(namaProp);
            l.setNama_kab(namaKab);
            l.setNama_kec(namaKec);
            l.setNama_kel(namaKel);
            l.setKode_pos(txt_kodepos.getText() );
            l.setNo_tlp(txt_noTlp.getText());
            l.setFax(txt_fax.getText() );
            l.setEmail(txt_email.getText());

            if(dl.updateLokasi(l) == true){
                JOptionPane.showMessageDialog(this, "Data tersimpan");
                clear();
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void combo_propItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_propItemStateChanged
        // TODO add your handling code here:
        if(combo_prop.getSelectedIndex() > 0){
            int kode = lp.get( (combo_prop.getSelectedIndex())-1).getId_prop();
            lkab = new daoKabupaten().getKabupatenByid(kode);
            init_combo_kabupaten(lkab);
            namaProp = combo_prop.getSelectedItem().toString();
        }else {
            combo_kab.removeAllItems();
            combo_kec.removeAllItems();
            combo_kel.removeAllItems();
        }
    }//GEN-LAST:event_combo_propItemStateChanged

    private void combo_kabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kabItemStateChanged
        // TODO add your handling code here:
        if(combo_kab.getSelectedIndex() > 0){
            int kode = lkab.get( (combo_kab.getSelectedIndex())-1).getKode_kab();
            lkec = new daoKecamatan().getKecamatanByid(kode);
            init_combo_kecamatan(lkec);
            namaKab = combo_kab.getSelectedItem().toString();
        }else {
            combo_kec.removeAllItems();
            combo_kel.removeAllItems();
        }
    }//GEN-LAST:event_combo_kabItemStateChanged

    private void combo_kecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kecItemStateChanged
        // TODO add your handling code here:
        if(combo_kec.getSelectedIndex() > 0){
            int kode = lkec.get( (combo_kec.getSelectedIndex())-1).getKode_kec();
            lkel = new daoKelurahan().getKelurahanByid(kode);
            init_combo_kelurahan(lkel);
            namaKec = combo_kec.getSelectedItem().toString();
        }else {
            combo_kel.removeAllItems();
        }
    }//GEN-LAST:event_combo_kecItemStateChanged

    private void combo_kelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_kelItemStateChanged
        // TODO add your handling code here:
        if(combo_kel.getSelectedIndex() > 0){
            namaKel = combo_kel.getSelectedItem().toString();
            int KP = lkel.get(combo_kel.getSelectedIndex()-1).getKodepos();
            txt_kodepos.setText(KP+"");
        }else {
            txt_kodepos.setText("");
        }
    }//GEN-LAST:event_combo_kelItemStateChanged

    private void combo_kelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_kelActionPerformed
        // TODO add your handling code here:
        if(combo_kel.getSelectedIndex() > 0){
            namaKel = combo_kel.getSelectedItem().toString();
            int KP = lkel.get(combo_kel.getSelectedIndex()-1).getKodepos();
            txt_kodepos.setText(KP+"");
        }else {
            txt_kodepos.setText("");
        }
    }//GEN-LAST:event_combo_kelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox combo_kab;
    private javax.swing.JComboBox combo_kec;
    private javax.swing.JComboBox combo_kel;
    private javax.swing.JComboBox combo_prop;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_alamatPerush;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fax;
    private javax.swing.JTextField txt_kodepos;
    private javax.swing.JTextField txt_namaPerush;
    private javax.swing.JTextField txt_noTlp;
    // End of variables declaration//GEN-END:variables
    private void setDocument(){
        txt_fax.setDocument(new txtNumber_validator());
        txt_kodepos.setDocument(new txtNumber_validator());
        txt_noTlp.setDocument(new txtNumber_validator());
    }
}
