/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import  java.io.*;
import java.util.*;
/**
 *
 * @author Arbab Ali
 */
public class Data {
    
    private final ArrayList<Player> players;
    private final ArrayList<field> feilds;
    
    public Data() {
    
       players=new ArrayList<>();
       feilds=new ArrayList<>();
    }
    /**
     *
     * Reads the Fields and Player data from file and creates ArrayList respectively 
     * @param filename
     * @throws FileNotFoundException
     * @throws InvalidInputException 
     */
    public void read_data(String filename) throws FileNotFoundException, InvalidInputException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
       /* if(!sc.hasNext())
        {
            throw new EmptyFileExceptions();
        }*/
        if(!sc.hasNextInt())
        {
            throw new InvalidInputException();
        }
        while(sc.hasNext()){
         
          int numProperty=sc.nextInt();
        for(int i=0;i<numProperty;i++)
        {
             field  newfield=null;
             
           String a=sc.next() ;
          switch(a){
            case "property":
                newfield= new property(1000);
                break;
            case "lucky":
                newfield= new lucky(sc.nextInt());
                break;
            case "service":
                newfield= new service(sc.nextInt());
                break;
            default:
                throw new InvalidInputException();
        }
         feilds.add(newfield);
            
        }
               
        int numPlayer=sc.nextInt();
        for(int i=0;i<numPlayer;i++)
        {
            Player newPlayer ;
            while(sc.hasNext())
            {
                String name=sc.next();
                switch(sc.next())
                {
                case "carefull":
                    newPlayer=new carefull(name);
                    break;
                case "greedy":
                    newPlayer=new greedy(name);
                    break;
                case "tactical":
                    newPlayer=new tactical(name);
                    break;
                default:
                    throw new InvalidInputException();
                }
            players.add(newPlayer);  
            ///SAVING THE OWNERS ADDRESSES 
            
              
        }
        
        }
   
        
    }
    }
 /**
  * Prints the information of arrayList attributes of type Player and Field
  * @param players
  * @param fields 
  */
//THIS METHOD WILL PRINT WHAT WE KNOW ABOUT FIELDS AND PLAYERS 
public void print_report(ArrayList<Player> players ,ArrayList<field> fields){
  System.out.println("BOARD OF GAME");
    for(field v:feilds)
    {
        System.out.println(v);
    }
    System.out.println("\nPLAYER IN THE GAME:-");
    for(Player p:players)
    {
        int count=0;
        for(field v:feilds)
        {
         if(v.getOwner().equalsIgnoreCase(p.getName()))
         {
          count++;
         }
        }
        System.out.println( p.toString() + " Owned Properties :" + count  );
        
    }
    System.out.println("_______________________________________________");
   
}
/**
 * Reads the Data for dice from file  and simulates the game behavior   
     * @param diceFile
 * @throws FileNotFoundException
 * @throws InvalidInputException 
 */  
public void simulation(String diceFile) throws FileNotFoundException, InvalidInputException
{
 Scanner dice = new Scanner(new BufferedReader(new FileReader(diceFile)));   
 /*   if(!dice.hasNext())
        {
            throw new EmptyFileExceptions();
        }
*/
 print_report(players,feilds);
    System.out.println("\nSIMULATION....\n");
    
    //ArrayList<Player>lossers=new ArrayList<>();
    int roundCount=0;
    Iterator<Player> p_Itr=players.iterator();
    Player p;
    while( dice.hasNextInt()){   
     //  int random_int = (int)(Math.random() * (6 - 1 + 1) + 1);
     if(!p_Itr.hasNext())
        { 
            p_Itr=players.iterator();
        }
        
            p=p_Itr.next();
           
        int i =dice.nextInt();
        System.out.println("\ndice:"+i);
        
       p.setPosition(p.getPosition()+i);
       if(p.getPosition()>feilds.size())
       {
           p.setPosition(1);
       }
        field v=feilds.get(p.getPosition()-1);
        
        System.out.println("Playing NOW: "+p.getName());    
        System.out.println("LANDED ON Field OF: "+v.getType() +" "+v.getOwner());
          
              v.MoneyDeal(p,v.ownerObject);
            
            if(p.getBalance()<0)
            { 
                p.lossLands(feilds);
               // lossers.add(p);
                p_Itr.remove();
            }
        
        
    
    roundCount+=1;
    System.out.println("\nroundCount: " +roundCount +"\n");
    print_report(players,feilds);
    }
   
    }
    
    
}

