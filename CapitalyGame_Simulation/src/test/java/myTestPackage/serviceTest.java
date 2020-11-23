/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.service;
import mypackage.Player;
import mypackage.greedy;
import mypackage.carefull;
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
public class serviceTest {
    
    public serviceTest() {
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
     * Test of MoneyDeal method, of class service.
     */
    @Test
    public void testConstructor()
    {
        service instance=new service(1000);
        
        assertEquals(instance.getStatus(),Status.owned);
       
        assertEquals(instance.getPrice(),1000); 
        assertEquals(instance.getType(),"service");
        assertEquals(instance.getOwner(),"bank");
       
    }
    
    @Test
    public void testMoneyDeal()
    {
         service instance=new service(1000);
        Player p =new greedy ("arbab");
        Player other=new carefull("d1cpld");
        instance.MoneyDeal(p);
       
       assertEquals(p.getBalance(),9000); 
       
       instance.MoneyDeal(p, other);
       assertEquals(p.getBalance(),8000);
       
    }
    
}
