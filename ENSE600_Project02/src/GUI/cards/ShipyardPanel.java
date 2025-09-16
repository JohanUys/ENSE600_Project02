
package GUI.cards;

import GUI.*;
import LOGIC.*;

public class ShipyardPanel extends javax.swing.JPanel
{

    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;

    // CONSTRUCTOR =============================================================
    public ShipyardPanel(CardsPanel cardsPanel, Game game) 
    {        
        this.game = game;
        this.cardsPanel = cardsPanel;
        initComponents();
    } 
    
    // METHODS =================================================================
    public void updateDisplay()
    {
        
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
    
    // COMPONENT METHODS =======================================================
    
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
