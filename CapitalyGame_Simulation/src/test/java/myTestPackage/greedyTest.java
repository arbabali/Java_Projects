/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.property;
import mypackage.Player;
import mypackage.greedy;
import mypackage.field;
import mypackage.Status;
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
public class greedyTest {
    
    public greedyTest() {
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
     * Test of buyOrBuilt method, of class greedy.
     */
    @Test
    public void testConstructor(){
    greedy instance =new greedy("greed1");
    assertEquals(instance.getName(),"greed1");
    assertEquals(instance.getStrategy(),"greedy");
    assertEquals(instance.getBalance(),10000);
    assertEquals(instance.getPosition(),0);
    
    
    }
    @Test
    public void TestBuyOrBuilt()
    {
     Player instance= new greedy("greedy1");
     field f=new property(1000);
     field f2=new property(1000);
     
     instance.buyOrBuilt(f);
     //buy the land 
     assertEquals(instance.getBalance(),9000);
     assertEquals(f.getStatus(),Status.owned);
     assertEquals(instance.getName(),f.getOwner());
     
     //Buitl on the land
     instance.buyOrBuilt(f);
     assertEquals(instance.getBalance(),5000);
     assertEquals(f.getStatus(),Status.built);
     
     //NO ENOUGH MONEY 
     instance.setBalance(800);
     instance.buyOrBuilt(f2);
     assertEquals(f2.getStatus(),Status.free);
     
    }
    }
