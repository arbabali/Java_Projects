/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hunting_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Game Window with Playable User Interface and model.
 * @author Arbab Ali
 */
public class Window extends BaseWindow{
    
    private final int size;
    private final Model model;
    private final JLabel currPlayerLabel;
    private final JLabel limitRemainLabel;
    private final MainWindow mainWindow;
    private final JButton[][] buttonArray;
    private final Component[] refrenceToMainWindow;
    private final Color colorOfMainButton;

/**
 * Constructor for GameWindow ,initialize model and other variables.Creates the Panel of gridLayout for game buttons and two labels on top and bottom on BoxLayout.
 * @param size
 * @param mainWindow 
 */
    public Window(int size,MainWindow mainWindow) {
        this.size = size;
        this.mainWindow = mainWindow;
        mainWindow.getWindowList().add(this);
           refrenceToMainWindow = mainWindow.getContentPane().getComponents();
       colorOfMainButton=((refrenceToMainWindow[0].getAccessibleContext().getAccessibleChild(size%3)).getAccessibleContext().getAccessibleComponent().getBackground());
      
      model=new Model(size);
      JPanel top=new JPanel();
      top.setName("top");
      currPlayerLabel=new JLabel();
      limitRemainLabel=new JLabel();
      buttonArray=new JButton[size][size];
      currPlayerLabel.setText("Current Player:");
      limitRemainLabel.setText("Steps Remainig :"+model.getLimit());   
      JButton newGameButton=new JButton();
      newGameButton.setText("NEW GAME");
      newGameButton.setName("GameButton");
      newGameButton.addActionListener(e->newGame());
      newGameButton.setVisible(false);
      top.add(currPlayerLabel);
      top.add(newGameButton);
    
      
      
      
      JPanel mainPanel=new JPanel();
      mainPanel.setLayout(new GridLayout(size,size));
    
      for(int i=0;i<size;++i)
      {
          for(int j=0;j<size;++j)
          {
             
              buttonArray[i][j]=addButton(i,j);
              mainPanel.add(buttonArray[i][j]);
          }
      }
      
      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(top,BorderLayout.NORTH);
      getContentPane().add(mainPanel,BorderLayout.CENTER);
      getContentPane().add(limitRemainLabel,BorderLayout.SOUTH);
      
    //this.setResizable(false);
       this.setTitle(size+" x "+size+ " Game");
     
    }
    
    /**
     * Creates a new button and defines the actionListener for  button.s 
     * @param i
     * @param j
     * @return 
     */
    private JButton addButton(final int i ,final int j){

      final JButton button =new JButton(ChangeButtonText(model.getPlayer(i,j)));
      button.addActionListener( e->{
         
        if(model.checkWinOrEnd(i,j)==Status.None){
        Player p= model.step(i,j);
        if(model.getWarning()==Warning.None){
            updateCurrPlayerLabelText(button.getText());
            button.setText(ChangeButtonText(p));
        }
         updateLimitRemainLabelText();
         showGameOverMessage(model.checkWinOrEnd(i,j));
         
         if(model.getCurrPlayer()!=Player.None && model.isIfChosenPutItem() )
         {
                heighlightMoves(i,j);
         }else{notHighLightMoves();}
           
        }
        showWarningMessage();
        });
      //updateCurrPlayerLabelText(button.getText());
      //System.out.println(colorOfMainButton);
        button.setBackground(colorOfMainButton);
       
    return button;}
    /**
     * Changes the Color of Selected player and valid moves on the buttons grid.
     * @param i
     * @param j 
     */
    private void heighlightMoves(int i,int j )
    {
     
      for(int k=0;k<size;k++)
      
          for(int m=0;m<size;m++)
          {
              if(model.isValidMove(k, m) && buttonArray[k][m].getText().equalsIgnoreCase("") )
              {
                 
                 buttonArray[k][m].setBackground(Color.orange);
                 
              }else{
                  
                  buttonArray[k][m].setBackground(colorOfMainButton);
                  
                //buttonArray[k][m].setOpaque(true);
                  
              }
                      
          }
      buttonArray[i][j].setBackground(Color.LIGHT_GRAY);
    }
    private void notHighLightMoves()
    {
        for(int k=0;k<size;k++)
      
          for(int m=0;m<size;m++)
          {
            
                 buttonArray[k][m].setBackground(colorOfMainButton);
                      
          }
    }
    /**
     * Changes the Buttons Text according to the its current @Player value. 
     * @param currentPlayer
     * @return 
     */
    private String ChangeButtonText(Player currentPlayer)
    {
        if(currentPlayer==Player.None){
             return "";
      
         }else{
                return currentPlayer.name();
         }
        
           
    }
    /**
     * Shows Game Over Message if @status variable is no None and shows winner and also Changes NewGame buttons visibility.
     * @param status 
     */
    private void showGameOverMessage(Status status)
    {
        if(status!=Status.None){
        JOptionPane.showMessageDialog(this,status.name()+" Won !","GAME OVER !"
              , JOptionPane.PLAIN_MESSAGE);
        //;
   Accessible refrenceToTopPanel=  getContentPane().getAccessibleContext().getAccessibleChild(0).getAccessibleContext().getAccessibleChild(1);
   AccessibleComponent refrenceToButton=refrenceToTopPanel.getAccessibleContext().getAccessibleComponent();
   refrenceToButton.setVisible(true);
      //  newGame();
        }
    }
    /**
     * shows warning Message during game according to the models function @getWarning .
     */
    private void showWarningMessage()
    {
        switch(model.getWarning())
        {
            case NOTEMPTY -> JOptionPane.showMessageDialog(this,"THIS PLACE IS NOT EMPTY!","Warning!"
              , JOptionPane.WARNING_MESSAGE);
            case SELECT -> JOptionPane.showMessageDialog(this,"SELECT  PLAYER FIRST  !","Warning!"
              , JOptionPane.WARNING_MESSAGE);
            
            case INVALIDMOVE -> JOptionPane.showMessageDialog(this,"INVALID MOVE FOR PLAYER ! ","Warning!"
              , JOptionPane.WARNING_MESSAGE);
            case TURN -> JOptionPane.showMessageDialog(this,"IT's Other Players TURN ! ","Warning!"
              , JOptionPane.WARNING_MESSAGE);
              
        }
        model.setWarnningNone();
    }
    /**
     * Creates a newGame window and dispose the old one
     */
    private void newGame(){
        Window newWindow=new Window(size,mainWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        mainWindow.getWindowList().remove(this);
    }
    
    /**
     * Updates the Current Player label on top panel according to String passed 
     * @param CurrPlayerName 
     */
    private void updateCurrPlayerLabelText(String CurrPlayerName){
        if(model.getWarning()==Warning.None)
        currPlayerLabel.setText("Current Player :" +CurrPlayerName );
        
    }
    /**
     * Changes the value of bottom panel's label to the  steps remain after each move. 
     */
    private void updateLimitRemainLabelText()
    {
     limitRemainLabel.setText("Steps Remainig :"+model.getLimit());   
    }
    @Override
    /**
     * removes the window from mainWindow List and exits the window.
     */
    protected void doUponExit()
    {
        super.doUponExit();
        mainWindow.getWindowList().remove(this);
    }
}
