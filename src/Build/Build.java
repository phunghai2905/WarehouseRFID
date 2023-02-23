/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Build;

import GUI.DN;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author MSI
 */
public class Build {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        
        DN a=new DN();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }
}
