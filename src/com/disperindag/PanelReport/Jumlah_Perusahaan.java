/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.PanelReport;

import java.awt.event.ActionListener;

/**
 *
 * @author oscar
 */
public class Jumlah_Perusahaan extends javax.swing.JPanel {

    /**
     * Creates new form Jumlah_Perusahaan
     */
    public Jumlah_Perusahaan() {
        initComponents();
    }
    public void addActionListener_BtnOK(ActionListener l){
        btn_ok.addActionListener(l);
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
        btn_ok = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/disperindag/img/printer.png"))); // NOI18N
        btn_ok.setText("CETAK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btn_ok)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ok)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
