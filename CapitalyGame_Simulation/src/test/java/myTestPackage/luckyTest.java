/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.lucky;
import mypackage.Status;
import mypackage.Player;
import mypackage.carefull;
import mypackage.greedy;
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
public class luckyTest {
    
    public luckyTest() {
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
     * Test of MoneyDeal method, of class lucky.
     */
    @Test
    public void testConstructor()
    {
        lucky instance=new lucky(1000);
        
        assertEquals(instance.getStatus(),Status.owned);
       
        assertEquals(instance.getPrice(),1000); 
        assertEquals(instance.getType(),"Lucky");
        assertEquals(instance.getOwner(),"ForEveryone");
       
    }
    
    @Test
    public void testMoneyDeal()
    {
         lucky instance=new lucky(1000);
        Player p =new greedy ("arbab");
        Player other=new carefull("d1cpld");
        instance.MoneyDeal(p);
       
       assertEquals(p.getBalance(),11000); 
       
       instance.MoneyDeal(p, other);
       assertEquals(p.getBalance(),12000);
       
    }
}
