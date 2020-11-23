/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hunting_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *Main Window with game options and information about game in the menu
 * @author Arbab Ali
 */
public class MainWindow  extends BaseWindow{
    
   private final List<Window> gameWindows = new ArrayList<>();
   private final Integer [] sizeList=new Integer[]{3,5,7};
   //private final Color [] colorList=new Color[]{Color.PINK,Color.CYAN,Color.MAGENTA};
    
   /**
    * takes height and width and returns Main Window with game options and information about game in the menu.
    * @param height
    * @param width 
    */
    public MainWindow(int height, int width) {
       
      JPanel  buttonPanel =new JPanel();
      buttonPanel.setLayout(new FlowLayout());
      for (Integer size:sizeList)
       {
           buttonPanel.add(createButton(size));
       }
      buttonPanel.setName("buttonPanel");
      
      getContentPane().setLayout(new BorderLayout());
      
      getContentPane().add(buttonPanel,BorderLayout.NORTH);
      
      String Text="\nAbout GAME \nHunting is a two-player game, played on a board consists  of nxn fields,"
              + " where the first  player (call him fugitive) tries to run away, while the second player (the hunter) tries to capture him/her. "
              + "Initially, the character of the fugitive is at the center of the board, while the hunter has four characters (one at each corner)."
              + "The players take turnsmoving theircharacter (hunter can choose from 4) 1 step on the board (they cannot step on each others character)."
              + " The objective of the hunter is to surround the fugitive in at most 4nsteps, so it won’t be able to move.";
      
      JPanel infoPanel =new JPanel();
      JTextArea display =new JTextArea(Text);
    
      display.setBackground(this.getBackground());
      display.setEditable(false);
      display.setLineWrap(true);
      display.setWrapStyleWord(true);
      infoPanel.setName("infoPanel");
      infoPanel.add(display);
      
      getContentPane().add(display,BorderLayout.CENTER);
      
      JTextArea copyRight=new JTextArea("All rights Reserved by : Arbab Ali");
      copyRight.setBackground(this.getBackground());
      getContentPane().add(copyRight,BorderLayout.AFTER_LAST_LINE);
      
      //MENU BAR 
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu MainMenu=new JMenu("Menu");
      menuBar.add(MainMenu);
      
     JMenu gameMenuItem=new JMenu("Levels");
     for(Integer size:sizeList)
     {
         gameMenuItem.add(createMenuItem(size));
     }
      
    
     MainMenu.add(gameMenuItem);
      
     JMenuItem aboutMenuItem =new JMenuItem("About");
     MainMenu.add(aboutMenuItem);
      aboutMenuItem.addActionListener((ActionEvent e)->{
          String aboutText="""
                           This Project is created by Arbab Ali for  Program Technology Course
                           NAME : ARBAB ALI 
                           NEPTUN: D1CPLD
                           GROUP : 3 
                           Teacher : Balázs Pintér 
                           
                           """;
         JOptionPane.showMessageDialog(this, aboutText ,"INFROMATION ABOUT AUTHOR", JOptionPane.INFORMATION_MESSAGE);
      });
        
      JMenuItem exitMenuItem=new JMenuItem("Exit");
      MainMenu.add(exitMenuItem);
      exitMenuItem.addActionListener((ActionEvent e) -> {
          showExitConfrimation();
       });
     
    }

    /**
     * Action Listener for Clicking the Button to  Create  a new  game window .
     * @param size
     * @return 
     */
        private ActionListener getActionListener(final int size) {
            return new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Window window=new Window(size,MainWindow.this);
                    window.setVisible(true);
                   gameWindows.add(window);
                }
            };


        }
    /**
     * takes size and creates a button with size text name and action listener according to size 
     * @param size
     * @return 
     */
     private JButton createButton(Integer size)
        {
       JButton newButton = new JButton();
        newButton.setText(size+"x"+size);
        newButton.setName(size.toString());
        newButton.addActionListener(getActionListener(size));  
        return newButton;
        }
     /**
      * Creates menu item with @param size and adds action Listener to the menuItem according to size.
      * @param size
      * @return 
      */
     private  JMenuItem  createMenuItem(int size)
      {
          JMenuItem menuItem=new JMenuItem(size+"x"+size);
          menuItem.addActionListener(getActionListener(size));
          return menuItem;
      }
     /**
      * To get windows List 
      * @return 
      */
   public List<Window> getWindowList() {
        return gameWindows;
    }
    
    @Override
    /**
     * exits the window on call
     */
    protected void doUponExit() {
        System.exit(0);
    }
    
    
}
