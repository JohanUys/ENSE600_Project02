package LOGIC.events;

import LOGIC.*;

public class StormEvent implements Events
{
    @Override 
    public int getWeighting()
    {
        return 20;
    }
    
    @Override
    public void initializeObjects()
    {
        
    }
    
    @Override
    public String getIntroText()
    {
        return """
               Captain! There's a massive storm on the horizon!
               The faster our ship is, the worse it is at handling storms!
               The more cargo we have, the more likely we are to sustain damages!
               What should we do?
               """;
    }
    
    @Override
    public String getCardName()
    {
        return "EventStormCard";
    }
}