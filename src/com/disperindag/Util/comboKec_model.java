/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import com.disperindag.dao.daoKecamatan;
import com.disperindag.model.kecamatan;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author oscar
 */
public class comboKec_model extends DefaultComboBoxModel<Object>{
    List<kecamatan> lk = null;

    public comboKec_model() {
        lk = new daoKecamatan().getKecamatan();
    }

    @Override
    public int getSize() {
        return lk.size();
    }

    @Override
    public String getElementAt(int index) {
        return lk.get(index).getNama_kecamatan();
    }

}
