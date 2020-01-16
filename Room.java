import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private int roomID;
    private int itemID;
    private ArrayList<Item> items;

    private int roomItem;
    private String itemName;
    private int itemWeight; 
    private int number;
    
    public int sand;
    private int stone;
    private int iron;
    public int diamond;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, int roomID, int itemID) 
    {
        this.roomID = roomID;
        this.itemID = itemID;
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public int getRoomID(){
        return roomID;   
    }

    public int getItemID(){
        return itemID;   
    }

    public void createItems(){
        if(getItemID() == (1)){
            itemName = "wood"; 
            int wood = 0;
            itemWeight = 1;
        }
        else if(getItemID() == (2)){
            itemName = "sand"; 
            int sand = 0;
            itemWeight = 1;
        }  
        else if(getItemID() == (3)){
            itemName = "stone"; 
            int stone = 0;
            itemWeight = 1;
        }  
        else if(getItemID() == (4)){
            itemName = "diamond"; 
            int diamond = 0;
            itemWeight = 5;
        }  
        else if(getItemID() == (5)){
            itemName = "iron"; 
            int iron = 0;
            itemWeight = 3;
        }  
    }

    public String getItemName(){
        if(getItemID() == (1)){
            itemName = "wood";
        } 
        else if(getItemID() == (2)){
            itemName = "sand";
        }
        else if(getItemID() == (3)){
            itemName = "stone";
        } 
        else if(getItemID() == (4)){
            itemName = "diamond";
        }
        else if(getItemID() == (5)){
            itemName = "iron";
        }
        return itemName;
    }

    public int getItemNumber(){
        if(getItemID() == (1)){

        }
        return number;
    }
}
