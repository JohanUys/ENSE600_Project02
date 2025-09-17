package LOGIC.ships;

import LOGIC.Ship;

//Warship
//Level 4

public class FirstRate extends Ship
{
    //========== PROPOERTIES ==========

    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 5;
    protected static int baseMaxHoldSpace = 4;
    protected static int baseGuns = 100;
    protected static int basePrice = 300;
    
    //========== CONSTRUCTOR ===========
    public FirstRate()
    {
        super("First Rate");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
