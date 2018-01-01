/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.dbBackup;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class BackupDB {
    
    public boolean backupDB(String dbName, String dbUserName, String dbPassword, String path) {
 
        String executeCmd = "mysqldump -u" + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path +"/backup.sql";
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd} );
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Sukses Backup Data");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Backup Data gagal");
                System.out.println("Could not create the backup");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
 
        return false;
    }
    
    public boolean restoreDB(String dbUserName, String dbPassword, String source) {
 
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source "+source};
 
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Sukses Backup Data");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Backup Data gagal");
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return false;
    }
    
    public static void main(String[] args) {
        BackupDB bd = new BackupDB();
        bd.backupDB("db_disperindag", "root", "root", "D:/");
    }
    
}
