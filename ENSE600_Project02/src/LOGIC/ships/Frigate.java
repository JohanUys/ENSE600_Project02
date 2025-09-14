package LOGIC.ships;

//Warship
//Level 2

public class Frigate extends Ship
{
    //========== PROPOERTIES ==========

    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 15;
    protected static int baseMaxHoldSpace = 2;
    protected static int baseGuns = 40;
    protected static int basePrice = 100;
    
    //========== CONSTRUCTOR ===========
    public Frigate()
    {
        super("Frigate");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
