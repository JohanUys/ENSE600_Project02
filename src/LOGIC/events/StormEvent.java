package LOGIC.events;

import java.util.Random;
import LOGIC.*;
import GUI.*;

public class StormEvent implements Events
{
    @Override
    public int getWeighting() 
    {
        return 100; // Frequency weight
    }


    @Override
    public void trigger(Game game, CardsPanel cardsPanel) 
    {
        Player player = game.getPlayer();
        Ship ship = player.getShip();
        Random random = new Random();
        
        int roll = random.nextInt(100);
        
        // The bigger this number, the more likely we are to sink
        int shipWeakness = ship.getHold().size()*5 + ship.getMaxSpeed();

        if(roll < shipWeakness) 
        {
            // Clear cargo and deduct gold repair cost
            int repairCost = random.nextInt(30); //0-29 gold
            if(repairCost > player.getGold())
                repairCost = player.getGold();

            player.subtractGold(repairCost);
            ship.getHold().clear();
        }
        
        cardsPanel.getMainFrame().getDialoguePanel().displayText("You have encountered a storm");
    }
}
