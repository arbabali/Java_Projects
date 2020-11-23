/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.Status;
import mypackage.field;
import mypackage.property;
import mypackage.tactical;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arbab Ali
 */
public class tacticalTest {
    
    public tacticalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buyOrBuilt method, of class tactical.
     */
   @Test
    public void testConstructor(){
    tactical instance =new tactical("tactical2");
    assertEquals(instance.getName(),"tactical2");
    assertEquals(instance.getStrategy(),"tactical");
    assertEquals(instance.getBalance(),10000);
    assertEquals(instance.getPosition(),0);
    
    
    }
    @Test
    public void TestBuyOrBuilt()
    {
     tactical instance= new tactical("tactical");
     field f=new property(1000);
     field f2=new property(1000);
     
     
     //FIRST TIME BUYING THE LAND 
     assertEquals(instance.isSecondChance,true); //first time he can buy 
     instance.buyOrBuilt(f);
     assertEquals(instance.isSecondChance,false); // now for 2nd time he cant buy 
     //buy the land 
     assertEquals(instance.getBalance(),9000);
     assertEquals(f.getStatus(),Status.owned);
     assertEquals(instance.getName(),f.getOwner());
     
     
     //player tried to buy couldnt buy 
     instance.buyOrBuilt(f);
     assertEquals(instance.getBalance(),9000);
     assertEquals(f.getStatus(),Status.owned);
     
     
     assertEquals(instance.isSecondChance,true);// for 3rd time he can buy
     
     instance.buyOrBuilt(f);
     //Now player bought the land
     assertEquals(instance.getBalance(),5000);
     assertEquals(instance.getName(),f.getOwner());
     assertEquals(f.getStatus(),Status.built);
     
     instance.buyOrBuilt(f);
     //Not enough money to buy 
     instance.setBalance(800);
     instance.buyOrBuilt(f2);
     assertEquals(f2.getStatus(),Status.free);
     
    }    
}
