package LOGIC.ships;

//Merchant
//Level 4

public class Indiaman extends Ship
{
    //========== PROPOERTIES ==========
    
    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 5;
    protected static int baseMaxHoldSpace = 15;
    protected static int baseGuns = 40;
    protected static int basePrice = 300;
    
    //========== CONSTRUCTOR ===========
    public Indiaman()
    {
        super("Indiaman");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
