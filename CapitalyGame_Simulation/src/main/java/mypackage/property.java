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
public class property extends field{

    public property(Integer price) {
        super("property", price, Status.free, "none");
    }
    private void PayOwner(Player p,Player Owner,int cost)
    {
         if(p.getBalance()>cost)
                                 Owner.setBalance(Owner.getBalance()+cost);
                            else
                                 Owner.setBalance(Owner.getBalance()+p.getBalance());
                            
                            p.setBalance(p.getBalance()-cost);
    }
    @Override
    
    public void MoneyDeal(Player p){}
    @Override
    /*
     * Does the Exchange of Money depending on status of feild  and players balance
     * @param p 
     * @param Owner
     */
    
    public void MoneyDeal(Player p,Player Owner) {
        
        switch(this.getStatus())
        {
            case free:
                        p.buyOrBuilt(this);
                        this.ownerObject=p;
                        break;
            case owned:
                        if(p.getName().equals(this.getOwner()))
                        {       p.buyOrBuilt(this);}
                       else
                        {  
                         PayOwner(p,Owner,500);
                        }
                        break;
            case built:
                    if(!(p.getName().equals(Owner.getName())))
                    { 
                   PayOwner(p,Owner,2000);
                    }
                        break;
                 
            default:
                break;
        }
        
        
    
    }
    
}
