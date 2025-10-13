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
    private final PlayerNameCard playerNameCard;
    private final StartCard startCard;
    private PortCard portCard;
    private MarketCard marketCard;
    private ShipyardCard shipyardCard;
    private MapCard mapCard;
    private TravelCard travelCard;
    private EventMerchantCard eventMerchantCard;
    private EventPirateCard eventPirateCard;
    private EventStormCard eventStormCard;
    private LootingCard lootingCard;

    // CONSTRUCTOR =============================================================
    public CardsPanel(MainFrame frame) 
    {
        // Store frame and game as fields 
        this.frame = frame;
        this.game = frame.getGame();
        
        // Initialise card layout 
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        // Initialise StartCard and PlayerNameCard immediately
        this.playerNameCard = new PlayerNameCard(frame);
        add(playerNameCard, "PlayerNameCard");
        this.startCard = new StartCard(frame);
        add(startCard, "StartCard");

        // Show PlayerNameCard first
        showCard("PlayerNameCard");
    }
    
    // GETTERS =================================================================
    public PlayerNameCard getPlayerNameCard() {return this.playerNameCard;}
    public StartCard getStartCard() {return this.startCard;}
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
        if (mapCard != null) mapCard.updateDisplay();
        if (portCard != null) portCard.updateDisplay();
        if (marketCard != null) marketCard.updateDisplay();
        if (lootingCard != null) lootingCard.updateDisplay();
        if (shipyardCard != null) shipyardCard.updateDisplay();
        if (eventStormCard != null) eventStormCard.updateDisplay();
        if (eventPirateCard != null) eventPirateCard.updateDisplay();
        if (eventMerchantCard != null) eventMerchantCard.updateDisplay();
    }
    
    public void createGameCards() {
        // Only create if not already created
        if (portCard != null) return;

        this.portCard = new PortCard(frame);
        this.marketCard = new MarketCard(frame);
        this.shipyardCard = new ShipyardCard(frame);
        this.mapCard = new MapCard(frame);
        this.travelCard = new TravelCard(frame);
        this.eventMerchantCard = new EventMerchantCard(frame);
        this.eventPirateCard = new EventPirateCard(frame);
        this.eventStormCard = new EventStormCard(frame);
        this.lootingCard = new LootingCard(frame);

        // Add to layout
        add(portCard, "PortCard");
        add(marketCard, "MarketCard");
        add(shipyardCard, "ShipyardCard");
        add(mapCard, "MapCard");
        add(travelCard, "TravelCard");
        add(eventMerchantCard, "EventMerchantCard");
        add(eventPirateCard, "EventPirateCard");
        add(eventStormCard, "EventStormCard");
        add(lootingCard, "LootingCard");
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
