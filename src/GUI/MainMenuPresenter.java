/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Nathius
 */
public class MainMenuPresenter implements ActionListener {
    
    private MainMenuView view;
    
    public MainMenuPresenter ()
    {
        
    }
    
    public void initView() {
        view = new MainMenuView();
        view.getNewButton().addActionListener(this);
        view.getLoadButton().addActionListener(this);
        view.getOptionsButton().addActionListener(this);
        view.getQuitButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.getNewButton()) 
        {
            view.displayMessageInDialog("new button");
        } 
        else if (e.getSource() == view.getLoadButton()) 
        {
            view.displayMessageInDialog("load button");
        } 
        else if (e.getSource() == view.getOptionsButton()) 
        {
            view.displayMessageInDialog("options button");
        } 
        else if (e.getSource() == view.getQuitButton()) 
        {
            view.displayMessageInDialog("quit button");
        } 
        
    }
}
