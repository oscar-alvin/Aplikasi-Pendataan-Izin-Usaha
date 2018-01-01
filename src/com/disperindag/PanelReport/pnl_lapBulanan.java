/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.PanelReport;

import com.disperindag.Util.comboKab_model;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class pnl_lapBulanan extends javax.swing.JPanel {

    private static String[] BULAN = {"JANUARI", "FEBRUARI", "MARET", "APRIL", 
        "MEI", "JUNI", "JULI", "AGUSTUS", "SEPTEMBER", "OKTOBER", "NOVEMBER", "DESEMBER"};
    private String bln_angka;
    /**
     * Creates new form pnl_lapBulanan
     */
    public pnl_lapBulanan() {
        initComponents();
        setComboModel();
        clear();
    }
    
    public void addActionListenerLAPBulanan(ActionListener l) {
        btn_ok.addActionListener(l);
    }

    private void setComboModel() {
        DefaultComboBoxModel bulan = new DefaultComboBoxModel();
        for (String bln : BULAN) {
            bulan.addElement(bln);
        }
        
        DefaultComboBoxModel tahun = new DefaultComboBoxModel();
        for (int i = 2000; i <= 5000; i++) {
            tahun.addElement(i);
        }
        
        combo_kab.setModel(new comboKab_model());
        combo_bulan.setModel(bulan);
        combo_tahun.setModel(tahun);
    }
    public String[] getBulan() {
        String[] a = null;
        try {
            String kab = combo_kab.getSelectedItem().toString();
            String tahun = combo_tahun.getSelectedItem().toString();
            
            if(!kab.equals("") && !bln_angka.equals("") && !tahun.equals("") ){
                a = new String[2];
                a[0] = kab;
                a[1] = bln_angka+"-"+tahun;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_kab = new javax.swing.JComboBox();
        combo_bulan = new javax.swing.JComboBox();
        btn_ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_tahun = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("WILAYAH");

        jLabel3.setText("BULAN");

        combo_kab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo_bulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_bulan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_bulanItemStateChanged(evt);
            }
        });

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/disperindag/img/printer.png"))); // NOI18N
        btn_ok.setText("CETAK");

        jLabel2.setText("TAHUN");

        combo_tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ok))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_kab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ok)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_bulanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_bulanItemStateChanged
        // TODO add your handling code here:
        if(combo_bulan.getSelectedIndex() > -1){
            if(combo_bulan.getSelectedIndex() < 10){
                bln_angka = "0"+(combo_bulan.getSelectedIndex()+1);
            }else {
                bln_angka = (combo_bulan.getSelectedIndex()+1)+"";
            }
        }
    }//GEN-LAST:event_combo_bulanItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox combo_bulan;
    private javax.swing.JComboBox combo_kab;
    private javax.swing.JComboBox combo_tahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void clear() {
        combo_bulan.setSelectedIndex(-1);
        combo_kab.setSelectedIndex(-1);
        combo_tahun.setSelectedIndex(-1);
    }
}
