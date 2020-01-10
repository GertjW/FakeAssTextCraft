
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Item currentItem;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        createItems();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room forest, winter, desert, jungle, jungle_tempel, village, savanna, house, cave, mineshaft, end, nether1, nether2, nether3, nether4, nether5, nether6;
      
        // create the rooms
        forest = new Room("You are now in the forest");
        winter= new Room("You are in a winter biome");
        desert = new Room("This is a sandy place, looks like a desert");
        jungle = new Room("this looks like a jungle");
        jungle_tempel = new Room("You found a hidden jungle tempel, maybe there are some secrets here.");
        village= new Room("You are now in a nice looking village, say hi to the people here!");
        savanna = new Room("You are in a Savanna");
        house = new Room("Welcome in you're own house");
        cave= new Room("You are under the ground, in a cave.");
        mineshaft= new Room("This is a MineShaft");
        end = new Room("This is the end, kill the dragon and finish the game.");
        nether1 = new Room("You are now in the Nether");
        nether2 = new Room("You are now in the Nether2");
        nether3 = new Room("You are now in the Nether3");
        nether4 = new Room("You are now in the Nether4");
        nether5 = new Room("You are now in the Nether");
        nether6 = new Room("Look an portal, a way out!");
        
        // initialise room exits
        forest.setExit("north", village);
        forest.setExit("east", winter);
        forest.setExit("south", desert);
        forest.setExit("west", forest);

        winter.setExit("east", cave);
        winter.setExit("west", forest);

        desert.setExit("north", forest);
        desert.setExit("south", jungle);

        jungle.setExit("north", desert);
        jungle.setExit("south", jungle_tempel);
        jungle.setExit("west", jungle);

        jungle_tempel.setExit("north", jungle);

        cave.setExit("south", mineshaft);
        cave.setExit("west", winter);

        mineshaft.setExit("north", cave);
        mineshaft.setExit("east", end);
        mineshaft.setExit("west", jungle_tempel);

        village.setExit("north", savanna);
        village.setExit("south", forest);

        savanna.setExit("east", nether1);
        savanna.setExit("south", village);

        nether1.setExit("north", nether2);
        nether1.setExit("east", nether3);
        nether1.setExit("south", nether4);

        nether2.setExit("east", nether5);
        nether2.setExit("south", nether1);

        nether3.setExit("north", nether5);
        nether3.setExit("east", nether6);
        nether3.setExit("west", nether1);

        nether4.setExit("north", nether1);

        nether5.setExit("south", nether3);
        nether5.setExit("west", nether2);

        nether6.setExit("south", savanna);
        nether6.setExit("west", nether3);

        currentRoom = forest;  // start game outside
    }
    private void createItems(){
        Item wood, stone, iron, diamond, sand;//kan nog meer toevoegd worden maar dit gaat om het idee, dit kan je doen door heel simpel der een item achter te zetten en te decaleren
        wood = new Item("Wood");
        stone = new Item("Stone");
        iron = new Item("Iron");
        diamond = new Item("Diamond");
        sand = new Item("Sand");
        currentItem = wood;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome in you're new survival world");
        System.out.println("Textcraft is a survival game, where you need to collect stuff.");
        System.out.println("Eventually you have to go to the end, and kill the Ender Dragon.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("use")){
            printUse();
        }
        else if (commandWord.equals("items")){
            ItemToGet();
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printUse(){
     System.out.println("Hier kun je wat mee bezig gaan om shit te hakken");
     System.out.println(currentItem.getItemDescription());
    }
    private void ItemToGet(){
         if(currentRoom.getShortDescription().equals("You are now in the forest")){
         System.out.println("You can get here wood");}
         else if(currentRoom.getShortDescription().equals("You are in a winter biome")){
         System.out.println("You can get here wood");}
         else if(currentRoom.getShortDescription().equals("This is a sandy place, looks like a desert")){
         System.out.println("You can get here sand");}
         else if(currentRoom.getShortDescription().equals("You found a hidden jungle tempel, maybe there are some secrets here.")){
         System.out.println("You can get here diamonds");}
        else if(currentRoom.getShortDescription().equals("this looks like a jungle")){
            System.out.println("You can get here wood");}
        else if(currentRoom.getShortDescription().equals("You are under the ground, in a cave.")){
            System.out.println("You can get here stone");}
        else if(currentRoom.getShortDescription().equals("You are now in the Nether4")){
            System.out.println("You can get here a potion");} //Speedpot
        else if(currentRoom.getShortDescription().equals("You are now in the Nether3")){
            System.out.println("You can get here a potion");} //Strengthpot
    else{System.out.println("You can't get anything here");}
}
    private void printHelp() 
    {
        System.out.println(currentRoom.getLongDescription());
        System.out.println("You can try to get some objects");
        System.out.println("In everyroom there are diffrent objects to farm");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help use");
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("You are just running around");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
