/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nathius
 */
public class MainMenuView extends JFrame{
    private JPanel mainImagePanel;
    private JPanel mainButtonPanel;
    
    private JLabel mainLabel;
    
    private JButton newButton;
    private JButton loadButton;
    private JButton optionsButton;
    private JButton quitButton;
    
    public MainMenuView()
    {
        //set up the main image panel
        mainImagePanel = new JPanel();
      
        mainLabel = new JLabel("mainSplash.jpg");
        mainImagePanel.add(mainLabel);
        
        //set up the main button panel
        mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new BoxLayout(mainButtonPanel, BoxLayout.Y_AXIS));
        
        newButton = new JButton("New Stronghold");
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainButtonPanel.add(newButton);
        
        int buttonSpacing = 10;
        
        mainButtonPanel.add(Box.createRigidArea(new Dimension(5,buttonSpacing)));
        loadButton = new JButton("Load");
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainButtonPanel.add(loadButton);
        
        mainButtonPanel.add(Box.createRigidArea(new Dimension(5,buttonSpacing)));
        optionsButton = new JButton("Options");
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainButtonPanel.add(optionsButton);
        
        mainButtonPanel.add(Box.createRigidArea(new Dimension(5,buttonSpacing)));
        quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainButtonPanel.add(quitButton);
        
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        container.add(mainImagePanel);
        container.add(mainButtonPanel);  
        container.add(Box.createVerticalGlue());
        
        
        container.setPreferredSize(new Dimension( 250 ,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }
    
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public JButton getNewButton()
    {
        return newButton;
    }
    
    public JButton getLoadButton()
    {
        return loadButton;
    }
    
    public JButton getOptionsButton()
    {
        return optionsButton;
    }
    
    public JButton getQuitButton()
    {
        return quitButton;
    }
}
