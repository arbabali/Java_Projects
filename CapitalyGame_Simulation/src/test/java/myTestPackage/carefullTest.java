/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.carefull;
import mypackage.property;
import mypackage.Status;
import mypackage.field;
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
public class carefullTest {
    
    public carefullTest() {
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
     * Test of getBuyLimit method, of class carefull.
     */
    @Test
    public void testConstructor(){
    carefull instance =new carefull("carefull2");
    assertEquals(instance.getName(),"carefull2");
    assertEquals(instance.getStrategy(),"carefull");
    assertEquals(instance.getBalance(),10000);
    assertEquals(instance.getPosition(),0);
    assertEquals((instance).getBuyLimit(),5000);
    
    
    }
    @Test
    public void TestBuyOrBuilt()
    {
     carefull instance =new carefull("carefull2");
     field f=new property(1000);
     field f2=new property(1000);
     
     instance.buyOrBuilt(f);
     //buy the land 
     assertEquals(instance.getBalance(),9000);
     assertEquals(f.getStatus(),Status.owned);
     assertEquals(instance.getName(),f.getOwner());
     assertEquals(instance.getBuyLimit(),(9000/2));
     
     //Buitl on the land
     instance.buyOrBuilt(f);
     assertEquals(instance.getBalance(),5000);
     assertEquals(f.getStatus(),Status.built);
     //NO ENOUGH LIMIT of MONEY 
     instance.setBalance(1500);
     instance.buyOrBuilt(f2);
     assertEquals(f2.getStatus(),Status.free);
     
    }
    
}
