/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nita.project.gui;

import javax.swing.UIManager;

/**
 *
 * @author Ritika Sahay
 * public class FrameA extends JFrame {
    private FrameB frameB;

   */

 
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//         try{
//            UIManager.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        new MainFrame().setVisible(true);
    }

}
