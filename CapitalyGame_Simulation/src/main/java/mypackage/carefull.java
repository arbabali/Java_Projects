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
public class carefull extends Player {
    private Integer buyLimit ;

    public carefull(String name) {
        super(name, 10000, 0, "carefull");
        this.buyLimit = this.getBalance()/2;
    }

    public int getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(Integer buyLimit) {
        this.buyLimit = buyLimit;
    }
    @Override
    /**
     * sets balance of carefull instance and also changes the buyLimit for object each time called 
     */
    public void setBalance(Integer b)
    {
        super.setBalance(b);
        buyLimit=this.getBalance()/2;
    }
    @Override
        /**
     * takes one parameter and check checks status of f and  changes status and subtract money form  this  conditionally
     * 
     * @param f
     */
    public void buyOrBuilt(field f) {
        
        if(f.getPrice()<buyLimit)
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
   
    @Override
    public  String toString()
    {
        
    return ("Name: " + this.getName() + " Strategy:" + this.getStrategy() +  " balance :" + this.getBalance() + " BuyLimit: " + buyLimit+  " Position: " +  this.getPosition() );
    
    }
    
    
    
    
}
