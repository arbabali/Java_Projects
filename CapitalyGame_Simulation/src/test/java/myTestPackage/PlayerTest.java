/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage;

import mypackage.Player;
import mypackage.greedy;
import mypackage.property;
import mypackage.Status;
import mypackage.field;
import java.util.ArrayList;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of lossLands method, of class Player and instances 
     */
    
  @Test
  
  public void TestLossLands()
  {
      
     ArrayList<field> fields=new ArrayList<>();
     
     field f1=new property(1000);
     field f2=new property(1000);
     field f3=new property(1000);
     
     fields.add(f1);
     fields.add(f2);
     fields.add(f3);
     
     //Chose any player to test , testing with greedy is 
     Player p=new greedy("greedy1");
     //buy all lands
     p.buyOrBuilt(fields.get(0)); //10000-1000=9000
     p.buyOrBuilt(fields.get(1));//9000-1000=8000
     p.buyOrBuilt(fields.get(2));//8000-1000=7000
     //built lands
     p.buyOrBuilt(fields.get(0)); // 7000-4000=3000
     
     p.lossLands(fields);
     
     for(field f:fields)
     {
         assertEquals(f.getStatus(),Status.free);
         assertEquals(f.getOwner(),"none");
     }
  }
    
}
