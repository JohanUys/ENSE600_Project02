package LOGIC.ships;

//Warship
//Level 3

public class SecondRate extends Ship 
{
    //========== PROPOERTIES ==========

    //SHIP INHERENT PROPERTIES
    protected static int baseMaxSpeed = 10;
    protected static int baseMaxHoldSpace = 3;
    protected static int baseGuns = 70;
    protected static int basePrice = 200;
    
    //========== CONSTRUCTOR ===========
    public SecondRate()
    {
        super("Second Rate");
        
        super.generateShipProperties(basePrice, baseMaxSpeed, baseMaxHoldSpace, baseGuns);
    }
}
