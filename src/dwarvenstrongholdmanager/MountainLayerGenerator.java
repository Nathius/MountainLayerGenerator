/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dwarvenstrongholdmanager;

import GUI.MainMenuPresenter;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nathius
 */
public class MountainLayerGenerator {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainMenuPresenter presenter = new MainMenuPresenter();
                presenter.initView();
            }           
        }); 
        
    }

    
}
