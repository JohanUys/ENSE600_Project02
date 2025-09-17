package LOGIC;

import LOGIC.ships.*;

import java.util.ArrayList;
import java.util.Random;

public class Shipyard
{
    //========== PROPERTIES ==========
    private final String portName;
    private final ArrayList<Ship> ships = new ArrayList<>(); 
    
    //========== CONSTRUCTOR ========== 
    public Shipyard(String portName) 
    {
        this.portName = portName;
        generateShips();
    }
    
    //========== GETTERS & SETTERS =======
    public String getPortName() {return this.portName;}
    public ArrayList<Ship> getShips() {return this.ships;}

    //========== METHODS ========== 
    
    // Handles ship trading logic
    public String tradeShip(int index, Player player) 
    {
        Ship currentShip = player.getShip();
        Ship selectedShip = ships.get(index);
        
        // Ensure selected ship can hold current cargo
        if (selectedShip.getMaxHoldSpace() < currentShip.getHold().size()) 
        {
            return "Not enough space for the cargo in your old ship! Maybe sell some.";
        }

        // Calculate final cost
        int tradeInValue = currentShip.getPrice();
        int cost = selectedShip.getPrice() - tradeInValue;

        if (cost > player.getGold()) 
        {
            return "You don't have enough gold, mate! Ships aint cheap!";
        }

        // PERFORM THE TRADE
        
        //load your cargo into the hold of the new ship.
        for(Good g : currentShip.getHold())
        {
            selectedShip.load(g);
        }
        currentShip.getHold().clear();
        
        //trade the ships
        player.setShip(selectedShip);
        ships.add(currentShip);
        ships.remove(selectedShip);
        
        // Pay for the ship
        player.subtractGold(cost);
        
        return null;
    }
    
    private void generateShips()
    {
        Random random = new Random();
        
        int numShips = random.nextInt(3)+1; //1-3 ships
            
        for(int i=0; i<numShips ; i++)
        {
            ships.add(initialiseRandomShip());
        }
    }
    
    // Randomly selects and returns a new instance of one of the ship types
    private Ship initialiseRandomShip()
    {
        Random random = new Random();
        int numShipTypes = 6;
        Ship ship = new Cutter();
        boolean shipCreated = false;
        
        while(!shipCreated)
        {
            switch(random.nextInt(numShipTypes))
            {
                case 0 -> {ship = new Cutter(); break;}
                case 1 -> {ship = new Brigantine(); break;}
                case 2 -> {ship = new Frigate(); break;}
                case 3 -> {ship = new Barque(); break;}
                case 4 -> {ship = new SecondRate(); break;}
                case 5 -> {ship = new Indiaman(); break;}
                case 6 -> {ship = new FirstRate(); break;}
            }
            
            shipCreated = true;

            //Check that there aren't two of the same ships in the port. 
            for(Ship s : this.ships)
            {
                if(s.getName().equals(ship.getName()))
                {
                    shipCreated = false;
                    break;
                }
            }
        }

        return ship;
    }
}