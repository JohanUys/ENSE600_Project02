package LOGIC.events;

import GUI.panels.CardsPanel;
import LOGIC.Events;
import LOGIC.Game;


public class PirateEvent implements Events{
    @Override
    public int getWeighting() 
    {
        return 0; // Frequency weight
    }

    @Override
    public void trigger(Game game, CardsPanel cardsPanel) 
    {
        
        
        cardsPanel.getMainFrame().getDialoguePanel().displayText("You have encountered a Pirate attack");
    }
}
