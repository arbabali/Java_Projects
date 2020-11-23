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

public abstract  class field {
    private final String type;
    private Integer price;
    private Status status;
    private String owner;
    public Player ownerObject;

    public Player getOwnerObject() {
        return ownerObject;
    }

    public void setOwnerObject(Player ownerObject) {
        this.ownerObject = ownerObject;
    }
    /**
     * Initialize the object of class field with following parameters 
     * @param type
     * @param price
     * @param status
     * @param owner 
     */
    public field(String type, Integer price, Status status, String owner) {
        this.type = type;
        this.price = price;
        this.status = status;
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Sets the Status of Field {FREE,OWNED,BUILT}
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public int getPrice() {
        return price;
    }


    public String getOwner() {
        return owner;
    }
    
    /**
     * deals  with  money( p.price)   according to the status of land for lucky and service instance 
     * @param p 
     */
   public abstract void MoneyDeal(Player p);
    /**
     * deals with the money(price ) of two instance of player with status of land 
     * @param p 
     */
   public abstract void MoneyDeal(Player p,Player o);
   @Override
   public String toString(){
       return ("Field: " + type + " Status: "+ status  + " Owner-> "+ owner + " Price-> " + price);
   }
}
