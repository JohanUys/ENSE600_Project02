package LOGIC.ships;

//Merchant
//Level 3

public class Barque extends Ship
{
    //========== PROPOERTIES ==========
    
    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 10;
    protected static int baseMaxHoldSpace = 10;
    protected static int baseGuns = 30;
    protected static int basePrice = 200;
    
    //========== CONSTRUCTOR ===========
    public Barque()
    {
        super("Barque");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
