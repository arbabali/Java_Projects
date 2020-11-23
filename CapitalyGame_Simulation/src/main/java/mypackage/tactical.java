/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

/**
 *
 * @author Arbab Ali
 */
public class tactical extends Player {
    
    public boolean isSecondChance=true;

    public tactical(String name) {
        super(name, 10000, 0, "tactical");
    }

    
    
    /**
     * checks status of field f  and variabale @isSecondChance  and performs operation accordingly 
     * @param f 
     */
    @Override
    public void buyOrBuilt(field f) {
        
        if( this.getBalance()>f.getPrice() && this.isSecondChance)
        {
            this.setBalance(this.getBalance()-f.getPrice());
             f.setOwner(this.getName());
            
            if(f.getStatus()==Status.free){
                f.setStatus(Status.owned);
                f.setPrice(4000);
            }
            else {
                f.setStatus(Status.built);
            }
           
            //MAKE IT FALSE FOR EVERY SECOND CHANCE
            isSecondChance=false;
        }
        else if(!isSecondChance)
        {
            isSecondChance=true;
        }
    }
    @Override
    public  String toString()
    {
        
    return ("Name: " + this.getName() + " Strategy:" + this.getStrategy() +  " balance :" + this.getBalance() + " isItSecondChance: " + isSecondChance +  " Position: " +  this.getPosition() );
    
    }    
}
