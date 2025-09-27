package LOGIC.events;

import LOGIC.*;
import LOGIC.ships.*;
import java.util.Random;

public class MerchantEvent implements Events
{
    //========== PROPERTIES ==========
    private final Random random = new Random();
    
    private Ship merchantShip;
    
    @Override
    public int getWeighting()
    {
        return 80;
    }
    
    @Override
    public void initializeObjects()
    {
        merchantShip = generateRandomMerchantShip();
        merchantShip.fillHoldRandomly();
    }
    
    @Override
    public String getIntroText()
    {
        return  "Captain! I see a merchant ship on the horizon!"
                + "\nLooks to be a " + merchantShip.getGuns() + " gun " + merchantShip.getName()
                + " sailing about " + merchantShip.getMaxSpeed() + " knots!"
                + "\nWhat should we do?";                
    }
    
    @Override
    public String getCardName()
    {
        return "EventMerchantCard";
    }
    
    
    
    // Weighted random merchant ship generator
    private Ship generateRandomMerchantShip()
    {
        int roll = random.nextInt(100); // 0–99

        if (roll < 40) return new Barque();             // 40% chance
        else if (roll < 70) return new Brigantine();    // 30% chance
        else if (roll < 90) return new Barque();        // 20% chance      
        else return new Indiaman();                   // 10% chance
    }
}
