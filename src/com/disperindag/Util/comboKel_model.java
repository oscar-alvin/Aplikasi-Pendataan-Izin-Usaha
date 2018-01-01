/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import com.disperindag.dao.daoKelurahan;
import com.disperindag.model.kelurahan;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class comboKel_model extends DefaultComboBoxModel<Object> {
    List<kelurahan> lk = null;

    public comboKel_model() {
        lk = new daoKelurahan().getKelurahan();
    }

    @Override
    public int getSize() {
        return lk.size();
    }

    @Override
    public String getElementAt(int index) {
        return lk.get(index).getNama_kelurahan();
    }

}
