
/**
 * class Objects - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Item
{
   /**
    * Fields
    */
    
   public int itemID;
   private int roomItem;
   private String itemName;
   private int itemWeight; 
   private int number;
   
   /**
    * @Setter and getter for item
    * @param Set String Name
    * @param return String;
    */
  
   public Item(String itemName, int itemID, int itemWeight){
       this.itemName = itemName;
    }
    
   public String getItemName2(){
      return itemName;
    }
    
   /**
    * Setter and getter for itemID
    * @param int set Item
    * 
    * Return item ID
    * @Return int
    */ 
   public void setItemID(){
     this.itemID = itemID;  
    }
   public int getItemID(){
     return itemID;
    }
   
    /**
     * Set the location of the item based on the roomID
     * @param int set itemRoom
     * 
     * Return the roomID of the item
     * @return int
     */
    public void setRoomItem(int roomItem)
    {
        this.roomItem = roomItem;
    }
    public int getRoomItem()
    {
        return roomItem;
    }
       
    /**
     * Set the value of the item
     * 0 is uselass, 1 is quest item
     * @param int 
     * 
     * Return the value of the item
     * @return int
     */
    public void setitemWeight(int itemWeight)
    {
        this.itemWeight = itemWeight;
    }
    
    public int getItemWeight()
    {
        return itemWeight;
    }
    public void createItems(){
    if(getItemID() == (1)){
        itemName = "wood"; 
        number = 0;
        itemWeight = 1;
    }    
}
   public String getItemName(){
     if(getItemID() == (1))
      itemName = "wood";
      return itemName;
    }
}
