/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Alvin
 */
public class txtNumber_validator extends PlainDocument {

        @Override
        public void insertString( int offs, String str, AttributeSet a )
                throws BadLocationException {

            if ( str == null ) {
                return;
            }

            char[] chars = str.toCharArray();
            boolean ok = true;

            for ( int i = 0; i < chars.length; i++ ) {

                try {
                    Integer.parseInt( String.valueOf( chars[i] ) );
                } catch ( NumberFormatException exc ) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                super.insertString( offs, new String( chars ), a );
            } else {
                JOptionPane.showMessageDialog(null, "Inputan harus angka", "", JOptionPane.ERROR_MESSAGE);
            }
        }
}
