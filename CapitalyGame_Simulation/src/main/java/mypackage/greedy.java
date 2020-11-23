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
public class greedy extends Player {

    public greedy(String name) {
        super(name, 10000, 0, "greedy");
    }
    
    @Override
        /**
     * Takes Parameter of Type @feild  
     * takes one parameter and check checks status of f and  changes status and subtract money form  this  conditionally
     * 
     * @param f
     */
    public void buyOrBuilt(field f) {
        
        if( this.getBalance()>f.getPrice())
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
        }
    }
}
