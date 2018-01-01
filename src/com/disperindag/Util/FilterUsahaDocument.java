/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author oscar
 */
public class FilterUsahaDocument extends PlainDocument {
    private JComboBox box;

    public FilterUsahaDocument(JComboBox box) {
        this.box = box;
    }

    public void insertString(int offset, String str, AttributeSet a)
            throws BadLocationException {
        if ((str == null) || (str.length() == 0))
            return;

        super.insertString(offset, str, null);
        updateBox();
    }

    private void updateBox() throws BadLocationException {
        String text = getText(0, getLength());
        FilterUsahaModel model = (FilterUsahaModel) box.getModel();
        model.setFilter(text);
    }

    public void remove(int offs, int len) throws BadLocationException {
        if (len == 0)
            return;

        super.remove(offs, len);
        updateBox();
    }

    public void replace(int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        super.replace(offset, length, text, attrs);
        updateBox();
    }
}
