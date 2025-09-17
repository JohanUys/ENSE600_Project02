package LOGIC.ships;

import LOGIC.Ship;

//Merchant or Warship 
//Level 1

public class Cutter extends Ship
{
    //=========== PROPERTIES ==========

    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 20;
    protected static int baseMaxHoldSpace = 1;
    protected static int baseGuns = 5;
    protected static int basePrice = 0;
    
    //========== CONSTRUCTOR ===========
    public Cutter()
    {
        super("Cutter");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}

