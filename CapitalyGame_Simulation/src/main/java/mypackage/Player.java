/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.ArrayList;

/**
 *
 * @author Arbab Ali
 */
public  abstract class Player {
    
    private String name;
    private Integer balance;
    private Integer position;
    private String strategy;
    /**
     * INTILIZE THE PLAYER CLASS OBJECT
     * @param name
     * @param balance
     * @param position
     * @param strategy 
     */
    public Player(String name, Integer balance, Integer position, String strategy) {
        this.name = name;
        this.balance = balance;
        this.position = position;
        this.strategy = strategy;
        this.position=0;
    }
    /**
     * resets the attributes of Properties  arrayList fields  to initial states  
     * @param fields 
     */
    public void lossLand(field f)
    {
        if(this.getName().equals(f.getOwner()))
       {
           f.setOwner("none");
           f.setStatus(Status.free);
           f.setPrice(1000);
       }
    }
     public void lossLands ( ArrayList<field> fields)
   {
       for(field f:fields){
           lossLand(f);
       }
   }
   
    /**
     * takes one parameter and check checks status of f and  changes status and subtract money form  this  conditionally
     * 
     * @param f
     */
    public abstract void buyOrBuilt(field f) ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return position;
    }
    
    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    
    @Override
   public String toString() {
        
    return ("Name: " + name + " Strategy:" + strategy +  " balance :" + balance + " Position: " +  position);
   
   }
}
