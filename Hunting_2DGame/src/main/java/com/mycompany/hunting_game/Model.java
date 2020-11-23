/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hunting_game;


/**
 *Model of the Game's functionality.
 *@author Arbab Ali
 */
 enum Status{
    Fugitive,Hunter,None}
 enum Warning 
 {
     INVALIDMOVE,SELECT,TURN,NOTEMPTY,None
 }
public class Model {
    private final int size;
    private Player currPlayer;
    private Player prevPlayer;
    private final Player[][] table;
    boolean ifChosenPutItem=false;
    int fugi_i;
    int fugi_j;
    int curr_i;
    int curr_j;
 
    int limit ;
   
    Status gameStatus;
    Warning gameWarning=Warning.None; 
    /**
     * takes size as parameter and initializes the variables  and also fills the Players table with starting positions. 
     * @param size 
     */
    public Model(int size)
    {
        limit=4*size;
        this.size=size;
        currPlayer=Player.None;
        table=new Player[size][size];
        
        for (int i=0;i<size;++i)
        {
            for (int j=0;j<size;++j)
            {
             table[i][j]=Player.None;
             if(i==0){
                 if(j==0){
                  table[i][j]=Player.H1;
                }
                 else if(j==size-1)
                {
                     table[i][j]=Player.H2;
                }
         }else  if(i==size-1)
         {
             if(j==0){
                  table[i][j]=Player.H3;
             }
             else if(j==size-1)
             {
                  table[i][j]=Player.H4;
             }
         }else if(i==size/2 && j==size/2)
         {
              table[i][j]=Player.F;
              //fugitivePosition=new Point (i,j);
              fugi_i=i;
              fugi_j=j;
         }
     
                   }
        }
    }

    
   public Player getCurrPlayer()
   { 
         return currPlayer;
   }

    /**
     * returns if item is selected or not
     */
    public boolean isIfChosenPutItem() {
        return ifChosenPutItem;
    }

    public Player getPlayer(int i, int j) {
        return table[i][j];
    }
   /**
    * 
    * @return's the Limit Remaining of Hunters turn.
    */
   public int getLimit()
   {
       return limit;
   }
   /**
    * 
    * @return's gameWarning value
    */
   public Warning getWarning()
  {
   return gameWarning;   
  }
   /**
    * sets the @gameWarning variable to None
    */
  public void setWarnningNone()
  {
      gameWarning=Warning.None;
  }
  /**
   *This is main function of model which checks if its selected player's turn and does  it  have valid move according to position i and j
   * if yes  swaps the position of selected player also decreases the limit in case of hunter also changes the @gameWarining variable accordingly.
   * @param i
   * @param j
   * @return 
   */
  public Player step(int i,int j)
   { 
      if(!isSamePlayer(i,j)){
      if(ifChosenPutItem ){ //if player is selected then put item
          if(isValidMove(i,j)){

          if(table[i][j]==Player.None){ //if place to put item is empty then put item 
             
              table[i][j]=currPlayer;
              prevPlayer=table[i][j];
          if(currPlayer==Player.F) { fugi_i=i;   fugi_j=j;}
          
           ifChosenPutItem=!ifChosenPutItem;
           if(currPlayer!=Player.F && currPlayer!=Player.None)
                 limit--; 
           
           currPlayer=Player.None;
          }
          else {
              gameWarning=Warning.NOTEMPTY;
           //   System.out.println("Chose some better Place");
          }
   
      }
         else{
              gameWarning=Warning.INVALIDMOVE;
        //  System.out.println("INVALID MOVE");
          
      }
      }
      else { //if player is not selected then select the player 
        if(table[i][j]!=Player.None) {
          prevPlayer=currPlayer; 
          // we put the selected buttons into current player
       if(table[i][j]!=Player.None) // if player value is not null then make it null to select 
       {
            currPlayer=table[i][j];
            curr_i=i;
            curr_j=j;
           table[i][j]=Player.None;
           
       }
       
       ifChosenPutItem=!ifChosenPutItem; /// then next click shall be to putt item
   
      }
        else
        {
            gameWarning=Warning.SELECT;
           // System.out.println("select Non-Empty Block");
        }
      }
    //System.out.println("i:"+i+" "+"j:"+j+"cnt:"+limit);
   
  
   }
      else
      {
             gameWarning=Warning.TURN;
      }
       return table[i][j];
   }
    
   
  /**
   * Function decides the winner by first checking the Limit of Steps remaining(in case of Fugitive) and then considering all possibles moves position are empty or not(in case of Hunter).
   * @param i
   * @param j
   * @return 
   */
  public Status checkWinOrEnd(int i,int j)
   {
       //System.out.println("fugi_i"+fugi_i +","+ "fugi_j"+ fugi_j);
       if(limit<0)
       {
           return Status.Fugitive;
       }
       
      //Non corner checking 
       if(fugi_i-1>=0 && fugi_j-1>=0   && fugi_i+1<=size-1 && fugi_j+1<=size-1 ){
         
          //System.out.println("NON CORNER !");
           if( table[fugi_i+1][fugi_j+1]!=Player.None && table[fugi_i+1][fugi_j]!=Player.None
            && table[fugi_i][fugi_j+1]!=Player.None && table[fugi_i+1][fugi_j-1]!=Player.None && table[fugi_i+1][fugi_j-1]!=Player.None 
                   && table[fugi_i-1][fugi_j]!=Player.None && table[fugi_i-1][fugi_j-1]!=Player.None && table[fugi_i][fugi_j-1]!=Player.None)
           {
               return Status.Hunter;
           }
       }
        //uppper  left coorner
        if(fugi_i-1<0 && fugi_j-1<0)
        {
          
        //  System.out.println("LEFT UP CORNER !");
            if  (table[fugi_i+1][fugi_j+1]!=Player.None && table[fugi_i+1][fugi_j]!=Player.None 
                    && table[fugi_i][fugi_j+1]!=Player.None ){
                return Status.Hunter;
            }
        }
        //Lower Left corner
        if(fugi_i+1>size-1 && fugi_j-1<0)
        {
            
        //  System.out.println("LEFT Low CORNER !");
            if  ( table[fugi_i][fugi_j+1]!=Player.None && table[fugi_i-1][fugi_j]!=Player.None
                    && table[fugi_i-1][fugi_j+1]!=Player.None )
            {
                return Status.Hunter;
            }
        }
        //Upper Right Corner
        if(fugi_i-1<0 && fugi_j+1>size-1){
            
       //   System.out.println("Righ UP CORNER !");
   
            if  ( table[fugi_i][fugi_j-1]!=Player.None && table[fugi_i+1][fugi_j]!=Player.None
                    && table[fugi_i+1][fugi_j-1]!=Player.None )
            {
                return Status.Hunter;
            }              
       }
        //Lower RIght Corner
        if(fugi_i+1>size-1 && fugi_j+1>size-1)
        {
            
       //   System.out.println("RIGHT Low CORNER !");
          if  ( table[fugi_i][fugi_j-1]!=Player.None && table[fugi_i-1][fugi_j]!=Player.None
                    && table[fugi_i-1][fugi_j-1]!=Player.None )
            {
                return Status.Hunter;
            }        
        }
       
     // System.out.println("None");
      
         
         return  Status.None;
     
          
   }
   /***
    * Checks(by comparing name string and @Player ) if @prevPlayer and current  player (table[i][j]) returns true otherwise return false.
    * @param i
    * @param j
    * @return 
    */
  public boolean  isSamePlayer(int i,int j){
       
       System.out.println("Prev PLAYERS: " + prevPlayer +" table[i][j]: "+ table[i][j]);
      System.out.println(prevPlayer==table[i][j] &&(! (prevPlayer.name().equals("F") || prevPlayer.name().equals("None")) ));
      if(prevPlayer==Player.F)
      {
          if(prevPlayer==table[i][j]){
           System.out.println("YES IT FUGITIVE SAME PLAYER");
            
                return true;
          }
         
      }
     else if((table[i][j]==Player.H1 || table[i][j]==Player.H2 || table[i][j]==Player.H3 || table[i][j]==Player.H4) 
             && (prevPlayer==Player.H1 || prevPlayer==Player.H2 || prevPlayer==Player.H3 || prevPlayer==Player.H4))
          {
              System.out.println("YES ITS SAME PLAYER:HUNTER");
             
              return true;
          }
      return false;
   }
  /**
   * Checks all King-Like moves with the @param i and @param j  returns true if any of move possible and false otherwise.
   * @param i
   * @param j
   * @return 
   */
  public boolean isValidMove(int i,int j){
     //down UP moves
      System.out.println("valid i,j "+ i +" : "+ j);
    if(curr_i+1==i && curr_j==j)
        return true;
    if(curr_i-1==i && curr_j==j)
        return true;
    //sides moves 
    if(curr_i==i && curr_j-1==j)
        return true;
    if (curr_i==i && curr_j+1==j)
        return true;
    //Diagonal
    if(curr_i+1==i && curr_j+1==j)
        return true;
    if(curr_i-1==i && curr_j-1==j)
        return true;
    if(curr_i+1==i && curr_j-1==j)
        return true;
    if(curr_i-1==i && curr_j+1==j)
        return true;
    if(curr_i==i && curr_j==j)
        return true;
   return false;   
  }
 
}

 
  

