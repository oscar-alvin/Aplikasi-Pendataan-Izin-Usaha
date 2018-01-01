
import com.disperindag.koneksi.myConnection;
import com.disperindag.view.FORM_MENU_DISPERINDAG;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvin
 */
public class main {
    private Connection con = null;
    
    private void cekKoneksi(){
        con = new myConnection().getConnection() ;
        if(con != null){
            FORM_MENU_DISPERINDAG fm = new FORM_MENU_DISPERINDAG(con);
            fm.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Koneksi Database gagal");
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            new main().cekKoneksi();
        }catch (UnsupportedLookAndFeelException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
        }
    }
}
