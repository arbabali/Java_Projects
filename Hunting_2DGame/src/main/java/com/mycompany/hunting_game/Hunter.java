/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hunting_game;

/**
 * Main function for creating a Main window of game 
 * @author Arbab Ali
 */
public   class Hunter {
    
    public static void main(String[] args)
    {
     
        MainWindow mainWindow=new MainWindow(400,500);
        mainWindow.setVisible(true);
    }
}
