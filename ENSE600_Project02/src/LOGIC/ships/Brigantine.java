package LOGIC.ships;

//Merchant 
//Level 2

public class Brigantine extends Ship
{
    //========== PROPOERTIES ==========

    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 15;
    protected static int baseMaxHoldSpace = 5;
    protected static int baseGuns = 20;
    protected static int basePrice = 100;
    
    //========== CONSTRUCTOR ===========
    public Brigantine()
    {
        super("Brigantine");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
