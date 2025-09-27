
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.events.MerchantEvent;

public class EventMerchantCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private MerchantEvent event;
    
    // CONSTRUCTOR =============================================================
    public EventMerchantCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    public void setEvent(Events event)
    {
        this.event = (MerchantEvent)event;
    }
    
    // METHODS =================================================================

    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonAvoid = new javax.swing.JButton();
        buttonChase = new javax.swing.JButton();

        buttonAvoid.setText("Avoid!");

        buttonChase.setText("Chase!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(buttonAvoid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(buttonChase)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAvoid)
                    .addComponent(buttonChase))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAvoid;
    private javax.swing.JButton buttonChase;
    // End of variables declaration//GEN-END:variables
}
