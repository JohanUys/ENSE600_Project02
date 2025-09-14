package GUI;

import java.awt.CardLayout;

public class MainPanel extends javax.swing.JPanel {

    // ========== PROPERTIES ==========
    private CardLayout cardLayout;

    // ========== CONSTRUCTOR ==========
    public MainPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Pass 'this' to child panels so they can control transitions
        add(new WelcomePanel(this), "Welcome");
        add(new StartGamePanel(this), "StartGame");
        add(new PortPanel(this), "PortPanel");
        add(new MarketPanel(this), "MarketPanel");
        add(new ShipyardPanel(this), "ShipyardPanel");
        

        cardLayout.show(this, "Welcome");
    }


    // ========== AUTO-GENERATED ==========
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

    // ========== METHODS ==========
    public void showCard(String name) {
        cardLayout.show(this, name);
    }
    
    // ========== AUTO-GENERATED ==========
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
