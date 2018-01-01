/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import java.util.ArrayList;
import javax.accessibility.Accessible;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author oscar
 */
public class FilterUsahaModel extends DefaultComboBoxModel {

    // Here we'll store the full list
    private Object[] items;
    // Here we have the list after the filter was applied
    private Object[] filteredItems;
    private Object selected;
    private JComboBox box;

    public FilterUsahaModel(Object[] items, JComboBox box) {
        this.items = items;
        this.filteredItems = items;
        this.box = box;
        box.setModel(this);
        box.setEditable(true);
        ((JTextField) box.getEditor().getEditorComponent())
                .setDocument(new FilterUsahaDocument(box));
        repaintPopup();
    }

    public void repaintPopup() {
        int size = box.getUI().getAccessibleChildrenCount(box);
        for (int i = 0; i < size; i++) {
            Accessible c = box.getUI().getAccessibleChild(box, i);
            if (c instanceof ComboPopup) {
                ((BasicComboPopup) c).doLayout();
            }
        }
    }

    public Object getElementAt(int index) {
        if ((index < 0) || (index >= filteredItems.length)) {
            return null;
        }
        return filteredItems[index];
    }

    public Object getSelectedItem() {
        return selected;
    }

    public void setSelectedItem(Object anObject) {
        if (anObject != null) {
            selected = anObject;
        }
    }

    public int getSize() {
        return filteredItems.length;
    }

    public void addElement(Object anObject) {
        // TODO NOT IMPLEMENTED
    }

    public int getIndexOf(Object anObject) {
        // TODO NOT IMPLEMENTED
        return -1;
    }

    public void insertElementAt(Object anObject, int index) {
        // TODO NOT IMPLEMENTED
    }

    public void removeAllElements() {
        // TODO NOT IMPLEMENTED
    }

    public void removeElement(Object anObject) {
        // TODO NOT IMPLEMENTED
    }

    public void removeElementAt(int index) {
        // TODO NOT IMPLEMENTED
    }

    public void setFilter(String filter) {
        if (filter == null) {
            filteredItems = items;
            return;
        }
        filter = filter.toUpperCase();
        if (items == null) {
            return;
        }
        ArrayList al = new ArrayList();
        for (int i = 0; i < items.length; i++) {
            try {
                if (((String) items[i]).toUpperCase().indexOf(filter) != -1) {
                    al.add(items[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filteredItems = al.toArray(new Object[0]);
        box.hidePopup(); // This is required so that the popup resizes
        box.showPopup();
        repaintPopup();
    }
}
