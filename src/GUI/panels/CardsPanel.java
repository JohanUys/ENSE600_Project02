package GUI.panels;

import GUI.*;
import GUI.cards.*;
import LOGIC.*;

import java.awt.CardLayout;

// PANEL CONTAINING CARD LAYOUT 
public class CardsPanel extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    //Card Layout
    private final CardLayout cardLayout;
    private String cardShown;
    
    //Card Layout Panels
    private final StartCard startCard;
    private final PortCard portCard;
    private final MarketCard marketCard;
    private final ShipyardCard shipyardCard;
    private final MapCard mapCard;
    private final TravelCard travelCard;
    private final EventMerchantCard eventMerchantCard;
    private final EventPirateCard eventPirateCard;
    private final EventStormCard eventStormCard;
    private final LootingCard lootingCard;

    // CONSTRUCTOR =============================================================
    public CardsPanel(MainFrame frame) 
    {
        //Store frame and game as fields 
        this.frame = frame;
        this.game = frame.getGame();
        
        //Initialise card layout 
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        //Initialize card panels
        this.startCard = new StartCard (frame);
        this.portCard = new PortCard(frame);
        this.marketCard = new MarketCard(frame);
        this.shipyardCard = new ShipyardCard(frame);
        this.mapCard = new MapCard(frame);
        this.travelCard = new TravelCard(frame);
        this.eventMerchantCard = new EventMerchantCard(frame);
        this.eventPirateCard = new EventPirateCard(frame);
        this.eventStormCard = new EventStormCard(frame);
        this.lootingCard = new LootingCard(frame);

        //Add cards panels to card layout
        add(startCard, "StartCard");
        add(portCard, "PortCard");
        add(marketCard, "MarketCard");
        add(shipyardCard, "ShipyardCard");
        add(mapCard, "MapCard");
        add(travelCard, "TravelCard");
        add(eventMerchantCard, "EventMerchantCard");
        add(eventPirateCard, "EventPirateCard");
        add(eventStormCard, "EventStormCard");
        add(lootingCard, "LootingCard");
        
        // Start game
        showCard("StartCard");
    }
    
    // GETTERS ================================================================= 
    public PortCard getPortCard() {return this.portCard;}
    public MarketCard getMarketCard() {return this.marketCard;}
    public ShipyardCard getShipyardCard() {return this.shipyardCard;}
    public MapCard getMapCard() {return this.mapCard;}
    public TravelCard getTravelCard() {return this.travelCard;}
    public EventMerchantCard getEventMerchantCard() {return this.eventMerchantCard;}
    public EventPirateCard getEventPirateCard() {return this.eventPirateCard;}
    public EventStormCard getEventStormCard() {return this.eventStormCard;}
    public LootingCard getLootingCard() {return this.lootingCard;}
    
    // METHODS =================================================================
    public final void showCard(String name) {
        cardLayout.show(this, name);
        cardShown = name;
        
        // Display help text for the shown card. 
        frame.getDialoguePanel().displayCardShownText(name);

        // Show PlayerPanel and only if not StartGamePanel
        if (!name.equals("StartCard")) {
            frame.getPlayerPanel().setVisible(true);
        } else {
            frame.getPlayerPanel().setVisible(false);
        }
        
        frame.getPlayerPanel().revalidate();
        frame.getPlayerPanel().repaint();
        frame.getDialoguePanel().revalidate();
        frame.getDialoguePanel().repaint();

        // Update everything that could need updating every time a card is changed. 
        updateCards();
        frame.getPlayerPanel().updateDisplay();
        frame.getPlayerPanel().getCompassInlay().repaint();
    }
    
    // Update cards that need updating.
    public void updateCards() 
    {
        mapCard.updateDisplay();
        portCard.updateDisplay();
        marketCard.updateDisplay();
        lootingCard.updateDisplay();
        shipyardCard.updateDisplay();
        eventStormCard.updateDisplay();
    }

    
    public boolean isShown(String name)
    {
        return name.equals(cardShown);
    }

    // AUTO GENERATED ==========================================================
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setPreferredSize(new java.awt.Dimension(260, 400));
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
