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
public class lucky extends field  {

    public lucky(Integer price) {
        super("Lucky", price, Status.owned, "ForEveryone");
    }
    /**
     * adds money to player p balance according to the price of feild lucky 
     * *@param p 
     */
    @Override
    public void MoneyDeal(Player p) {
        p.setBalance(p.getBalance()+this.getPrice());
    }
    

    @Override
      /**
     * Takes Parameter of Type Player   In case of Property takes two parameter and subtracts money from player p and Conditionally 
     adds money to Player Owner    
     * @param p 
     * @param Owner
     */
   public  void MoneyDeal(Player p,Player o){
       MoneyDeal(p);
   };
    
}
