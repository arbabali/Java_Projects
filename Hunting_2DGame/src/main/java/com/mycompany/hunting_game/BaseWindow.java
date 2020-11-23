/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hunting_game;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Basic window with title and basic functionality and UI
 * @author Arbab Ali
 */
public class BaseWindow  extends JFrame{
    
    public BaseWindow()
    {
        setTitle("HUNTING GAME");
        setSize(400,450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                showExitConfrimation();
            }
        });
       // URL url = Window.class.getResource("icon.png");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(url));
      //  pack();
        
    }
    protected  void showExitConfrimation()
    {
        int option = JOptionPane.showConfirmDialog(this,"Do You Want Exit ? ","Really?",JOptionPane.YES_NO_OPTION);
        if(option==JOptionPane.YES_OPTION)
        {
         doUponExit();  
        }
    }
    
    protected void doUponExit(){
        this.dispose();
    }
   
};
