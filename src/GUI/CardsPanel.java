package GUI;

import GUI.cards.*;
import LOGIC.*;

import java.awt.CardLayout;

// PANEL CONTAINING CARD LAYOUT 
public class CardsPanel extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final Game game;
    private final MainFrame frame;
    
    //Card Layout
    private final CardLayout cardLayout;
    private String cardShown;
    
    //Card Layout Panels
    private final WelcomePanel welcomePanel;
    private final StartGamePanel startGamePanel;
    private final PortPanel portPanel;
    private final MarketPanel marketPanel;
    private final ShipyardPanel shipyardPanel;
    private final MapPanel mapPanel;
    private final MapCanvas mapCanvas;

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
        this.welcomePanel = new WelcomePanel(this, game);
        this.startGamePanel = new StartGamePanel (this,game);
        this.portPanel = new PortPanel(this, game);
        this.marketPanel = new MarketPanel(this, game);
        this.shipyardPanel = new ShipyardPanel(this, game);
        this.mapPanel = new MapPanel(frame, this, game);
        this.mapCanvas = new MapCanvas(game.getMap());

        //Add cards panels to card layout 
        add(welcomePanel, "WelcomePanel");
        add(startGamePanel, "StartGamePanel");
        add(portPanel, "PortPanel");
        add(marketPanel, "MarketPanel");
        add(shipyardPanel, "ShipyardPanel");
        add(mapPanel, "MapPanel");
        
        //Show welcome panel
        showCard("WelcomePanel"); 
    }
    
    // GETTERS =================================================================
    public MainFrame getMainFrame() {return this.frame;}
    
    public PortPanel getPortPanel() {return this.portPanel;}
    public MarketPanel getMarketPanel() {return this.marketPanel;}
    public ShipyardPanel getShipYardPanel() {return this.shipyardPanel;}
    public MapPanel getMapPanel() {return this.mapPanel;}
    public MapCanvas getMapCanvas() {return this.mapCanvas;}
    
    // METHODS =================================================================
    public final void showCard(String name) {
        cardLayout.show(this, name);
        cardShown = name;
        
        marketPanel.updateDisplay();
        shipyardPanel.updateDisplay();
        
        // Center map on default port
        if ("MapPanel".equals(name)) {
            mapPanel.centerMapOnInitialPort();
        }
    }
    
    // Update panels
    public void updateAllPanels() {
        portPanel.updateDisplay();
        marketPanel.updateDisplay();
        shipyardPanel.updateDisplay();
    }

    
    public boolean isShown(String name)
    {
        return name.equals(cardShown);
    }

    // AUTO GENERATED ==========================================================
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(260, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
