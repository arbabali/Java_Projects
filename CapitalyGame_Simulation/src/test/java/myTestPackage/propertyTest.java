/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.greedy;
import mypackage.property;
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
public class propertyTest {
    
    public propertyTest() {
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
     * Test of MoneyDeal method, of class property.
     */
        @Test
    public void testConstructor()
    {
        property instance=new property(1000);
        
        assertEquals(instance.getStatus(),Status.free);
       
        assertEquals(instance.getPrice(),1000); 
        assertEquals(instance.getType(),"property");
        assertEquals(instance.getOwner(),"none");
       
    }
    
    @Test
    public void testMoneyDeal()
    {
         property  field1=new  property(1000);
         property  field2=new  property(1000);
        
         property  field3=new  property(1000);
         
         greedy p =new greedy ("arbab");
        
        greedy o=new greedy("d1cpld");
        
        
        
        field1.MoneyDeal(p,o); //player p owns the  field 1 9000
        field1.MoneyDeal(p,o); //player p builts the field 1 5000
       // assertEquals(field1.getStatus(),Status.built);
         field2.MoneyDeal(p,o); //player p owns the filed 2 4000
        field3.MoneyDeal(o,p); //player o owns the field 3 9000
        
        assertEquals(p.getBalance(),4000);
        assertEquals(o.getBalance(),9000);
       //when player o step on owned field of p  field2
       field2.MoneyDeal(o, p);
       
       //then  the o shall pay to p 500 
        assertEquals(p.getBalance(),4500);
        assertEquals(o.getBalance(),8500);
      
        //when the player o steps on the built field of p
        
        field1.MoneyDeal(o, p);
        //then it shall pay 2000 to p 
        
        assertEquals(p.getBalance(),6500);
        assertEquals(o.getBalance(),6500);
       
      // when p steps on the owned field3 of player o
      
      field3.MoneyDeal(p, o);
      
      assertEquals(p.getBalance(),6000);
      
      assertEquals(o.getBalance(),7000);
    }
    
}
