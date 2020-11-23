/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.FileNotFoundException;

/**
 *
 * @author Arbab Ali
 */
public class Main {
    
    
    public static void main (String[] args)
    {
        Data database = new Data();
        
       try{
           database.read_data("./TestCases/data2.txt");
           database.simulation("./TestCases/dice2.txt");
       }catch (FileNotFoundException ex){
           System.out.println("File not found!");
          System.exit(0);
       }
       catch (InvalidInputException ex)
       {
           System.out.println("Invalid Input");
          System.exit(0);
       }
     /*  catch(EmptyFileExceptions ex)
       {
        System.out.println("ONE OF INPUT FILES ARE EMPTY");
        System.exit(0);
       }*/
       
              
        
    }
    
  
    
}
