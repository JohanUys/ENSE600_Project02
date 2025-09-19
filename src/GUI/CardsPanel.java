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
    private final StartGamePanel startGamePanel;
    private final PortPanel portPanel;
    private final MarketPanel marketPanel;
    private final ShipyardPanel shipyardPanel;
    private final MapPanel mapPanel;

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
        this.startGamePanel = new StartGamePanel (this,game);
        this.portPanel = new PortPanel(this, game);
        this.marketPanel = new MarketPanel(this, game);
        this.shipyardPanel = new ShipyardPanel(this, game);
        this.mapPanel = new MapPanel(this, game);

        //Add cards panels to card layout
        add(startGamePanel, "StartGamePanel");
        add(portPanel, "PortPanel");
        add(marketPanel, "MarketPanel");
        add(shipyardPanel, "ShipyardPanel");
        add(mapPanel, "MapPanel");
        
        // Start game
        showCard("StartGamePanel");
    }
    
    // GETTERS =================================================================
    public MainFrame getMainFrame() {return this.frame;}
    
    public PortPanel getPortPanel() {return this.portPanel;}
    public MarketPanel getMarketPanel() {return this.marketPanel;}
    public ShipyardPanel getShipYardPanel() {return this.shipyardPanel;}
    public MapPanel getMapPanel() {return this.mapPanel;}
    
    // METHODS =================================================================
    public final void showCard(String name) {
        cardLayout.show(this, name);
        cardShown = name;

        // Show PlayerPanel and DialoguePanel only if not StartGamePanel
        if (!name.equals("StartGamePanel")) {
            frame.getPlayerPanel().setVisible(true);
            frame.getDialoguePanel().setVisible(true);
        } else {
            frame.getPlayerPanel().setVisible(false);
            frame.getDialoguePanel().setVisible(false);
        }
        frame.getPlayerPanel().revalidate();
        frame.getPlayerPanel().repaint();
        frame.getDialoguePanel().revalidate();
        frame.getDialoguePanel().repaint();

        updateAllPanels();

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
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
