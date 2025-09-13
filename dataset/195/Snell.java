/**
  * Program that creates, compiles 
  * and runs a JUnit test file.
  * 
  * Project 9.  
  * @author Avery Fox
  * @version 11-1-22
  */ 
  
public class Cake extends BakedItem {

/** The base rate. */

   public static final double BASE_RATE = 8;
   protected int layers;
   
   /**
   * Initilizes varibles.
   * @param nameIn - sets the name.
   * @param flavorIn - counts number of objects.
   * @param quantityIn - counts number of objects.
   * @param ingredientsIn - counts number of objects.
   * @param layersIn - counts num of layers.
   */

   public Cake(String nameIn, String flavorIn, int quantityIn, 
      int layersIn, String... ingredientsIn) { 
      
      super(nameIn, flavorIn, quantityIn, ingredientsIn); 
      layers = layersIn;
      
   }
   
   /**
    * Initilizes varibles.
    * Gets the name of the RingTorusList
    * @return listName - will return listName.
    *
    */
   
   public int getLayers() {
      return layers;
   }
   
   /**
    * Initilizes varibles.
    * Gets the name of the RingTorusList
    * @param layersIn - will return listName.
    *
    */
   
   public void setLayers(int layersIn) {
      this.layers = layersIn;
   }
  
  /**
   * Initilizes varibles.
   *@return super.calculateCost() + (SHIPPING_COST * weight);
   */
   
   public double price() {
      return (BASE_RATE * layers) * quantity;
   }
   
}