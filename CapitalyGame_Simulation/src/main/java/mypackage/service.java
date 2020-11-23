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
public class service extends field {

    public service(Integer price) {
        super("service", price, Status.owned, "bank");
    }

    @Override
      /**
     * subtracts the balance of player according to cost of service field
     * @param p 
     */
    public void MoneyDeal(Player p) {
        p.setBalance( p.getBalance()-this.getPrice());
        
    }
    
    @Override
   public  void MoneyDeal(Player p,Player o){
        MoneyDeal(p);
   };
}