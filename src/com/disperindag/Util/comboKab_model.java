/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import com.disperindag.dao.daoKabupaten;
import com.disperindag.model.kabupaten;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class comboKab_model extends DefaultComboBoxModel<Object> {

    List<kabupaten> lk = null;

    public comboKab_model() {
        lk = new daoKabupaten().getKabupaten();
    }
    
    @Override
    public int getSize() {
        return lk.size();
    }

    @Override
    public String getElementAt(int index) {
        return lk.get(index).getNama_kabupaten();
    }

}
