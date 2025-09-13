import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
  * Program that creates, compiles 
  * and runs a JUnit test file.
  * 
  * Project 9.  
  * @author Avery Fox
  * @version 11-1-22
  */ 


public class CakeTest {

   private Cake cake1 = new Cake("Birthday", "Chocolate", 1, 1, 
      "flour", "sugar", "cocoa powder", "vanilla", "eggs", "butter", 
      "baking soda", "baking powder", "salt");
   private Cake cake2 = new Cake("2-Layer", "Red Velvet", 1, 2, 
      "flour", "sugar", "cocoa powder", "food coloring", "eggs", 
      "butter", "baking soda", "baking powder", "salt");
   


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void getLayersTest() {
      int result1 = cake1.getLayers();
      Assert.assertEquals("", 1, result1);
      int result2 = cake2.getLayers();
      Assert.assertFalse("", 0 == result2);
   }
    
  /** A test that always fails. **/
   @Test public void setLayersTest() {
      cake1.setLayers(4);
      int result1 = cake1.getLayers();
      Assert.assertEquals("", 4, result1);
      cake1.setLayers(1);
      int result2 = cake2.getLayers();
      Assert.assertFalse("", 0 == result2);
   }  
    
    /** A test that always fails. **/
   @Test public void priceTest() {
      Assert.assertEquals("", 8, cake1.price(), 0.001);
      Assert.assertFalse("", 12 == cake2.price());
   }
    
}