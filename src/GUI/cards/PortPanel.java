package GUI.cards;

import GUI.*;
import LOGIC.*;

public class PortPanel extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;

    // CONSTRUCTOR =============================================================
    public PortPanel(CardsPanel cardsPanel, Game game) 
    {
        this.game = game;
        this.cardsPanel = cardsPanel;
        initComponents();
    }
    
    // Methods =================================================================
    public void updateDisplay() {
        labelPort.setText(game.getPort().getName());
        repaint();
        revalidate();
    }

    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPort = new javax.swing.JLabel();
        buttonViewMarket = new javax.swing.JButton();
        buttonViewShipyard = new javax.swing.JButton();
        buttonTravel = new javax.swing.JButton();

        labelPort.setText(game.getPort().getName()
        );

        buttonViewMarket.setText("View Market");
        buttonViewMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewMarketActionPerformed(evt);
            }
        });

        buttonViewShipyard.setText("View Shipyard");
        buttonViewShipyard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewShipyardActionPerformed(evt);
            }
        });

        buttonTravel.setText("Travel");
        buttonTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTravelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPort)
                    .addComponent(buttonViewMarket)
                    .addComponent(buttonViewShipyard)
                    .addComponent(buttonTravel))
                .addContainerGap(849, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewMarket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewShipyard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTravel)
                .addContainerGap(611, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    private void buttonViewMarketActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonViewMarketActionPerformed
    {//GEN-HEADEREND:event_buttonViewMarketActionPerformed
        cardsPanel.showCard("MarketPanel");
    }//GEN-LAST:event_buttonViewMarketActionPerformed

    private void buttonViewShipyardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonViewShipyardActionPerformed
    {//GEN-HEADEREND:event_buttonViewShipyardActionPerformed
        cardsPanel.showCard("ShipyardPanel");
    }//GEN-LAST:event_buttonViewShipyardActionPerformed
    // When 'Travel' button is clicked set map canvas and change to 'MapPanel' card
    private void buttonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTravelActionPerformed

        cardsPanel.showCard("MapPanel");
    }//GEN-LAST:event_buttonTravelActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTravel;
    private javax.swing.JButton buttonViewMarket;
    private javax.swing.JButton buttonViewShipyard;
    private javax.swing.JLabel labelPort;
    // End of variables declaration//GEN-END:variables
}
