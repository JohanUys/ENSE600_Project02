
package GUI.cards;

import GUI.*;
import LOGIC.*;
import java.util.ArrayList;

public class TravelCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private Port destination;
    private ArrayList<Events> events;
    private int triggerIndex;
    
    // CONSTRUCTOR =============================================================
    public TravelCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    //Called only by map card when travel button is pressed.
    public void setDestination(Port destination)
    {
        this.destination = destination;
    }
    
    public void leavePort()
    {
        // Show this card
        frame.getCardsPanel().showCard("TravelCard");       
        
        // Determine travel time 
        int travelTimeHours = game.getMap().calculatePortTravelTime(game.getPort().getName(), destination.getName(), game.getWind(), game.getPlayer().getShip());

        //Reset events
        if(events != null)
        {
            events.clear();
            triggerIndex = -1;
        }
        
        // Find any events that may occur.
        events = EventManager.generateEvents(game, travelTimeHours);
        
        // Trigger events
        triggerEvent();
    }
    
    public void triggerEvent()
    {
        // Increment the trigger index so the next event will be triggered.
        triggerIndex++;
        
        if(triggerIndex < events.size())
        {
            //Get the event
            Events event = events.get(triggerIndex);

            //Get the cardName of the event
            String cardName = event.getCardName();

            //Get the intro text for the event
            String intro = event.getIntroText();
            
            //Give the event to the necessary event card
            if(cardName.equals("EventMerchantCard")) {
                frame.getCardsPanel().getEventMerchantCard().setEvent(event);
            }
            if(cardName.equals("EventPirateCard")) {
                frame.getCardsPanel().getEventPirateCard().setEvent(event);
            }
            if(cardName.equals("EventStormCard")) {
                frame.getCardsPanel().getEventStormCard().setEvent(event);
            }

            //Hand over to the event card
            frame.getDialoguePanel().displayTextThenCard(intro, cardName);
        }
        else
        {
            arriveAtDestination();
        }
    }
    
    public void arriveAtDestination()
    {
        // Determine travel time & distance
        int distance = game.getMap().calculatePortDistance(game.getPort().getName(), destination.getName());
        int travelTimeHours = game.getMap().calculatePortTravelTime(game.getPort().getName(), destination.getName(), game.getWind(), game.getPlayer().getShip());
        int days = travelTimeHours / 24;
        int hours = travelTimeHours % 24;

        // CHANGE THE PORT AND THE WIND
        game.getWind().windChange();
        game.setPort(destination);
        
        // Display arrival message to user
        String arrivalText = "Arrived in " + game.getPort().getName() + "."
                             + "\nLogbook says the journey took " + days + " days and " + hours + " hours."
                             + "\nWe travelled " + distance + " nautical miles."
                             + "\nDocking ship....................";
        frame.getDialoguePanel().displayTextThenCard(arrivalText,"PortCard");
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
