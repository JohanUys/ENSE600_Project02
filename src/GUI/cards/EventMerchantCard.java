
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
    
    // SETTERS =================================================================
    public void setEvent(Events event) {this.event = (MerchantEvent)event;}
    
    // METHODS =================================================================

    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonAvoid = new javax.swing.JButton();
        buttonChase = new javax.swing.JButton();

        buttonAvoid.setText("Avoid!");
        buttonAvoid.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAvoidActionPerformed(evt);
            }
        });

        buttonChase.setText("Chase!");
        buttonChase.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonChaseActionPerformed(evt);
            }
        });

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

    private void buttonAvoidActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonAvoidActionPerformed
    {//GEN-HEADEREND:event_buttonAvoidActionPerformed
        String outroText = "Good plan captain, that would have been a difficult fight!";
        
        // Hand back to the travel card for the next event. 
        frame.getCardsPanel().getTravelCard().triggerEvent(outroText);
        
    }//GEN-LAST:event_buttonAvoidActionPerformed

    private void buttonChaseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonChaseActionPerformed
    {//GEN-HEADEREND:event_buttonChaseActionPerformed
        
        Ship playerShip = game.getPlayer().getShip();
        Ship merchantShip = event.getMerchantShip();
        
        //If we catch the ship then fight, else continue sailing. 
        if(EventManager.chase(playerShip, merchantShip))
        {
            String catchText = "We caught her, fire away!";
            
            if(EventManager.fight(playerShip, merchantShip))
            {
                //Give the merchant ship to the looting card
                frame.getCardsPanel().getLootingCard().setLootedShip(merchantShip);
                //Hand over to the looting card
                frame.getDialoguePanel().displayTextThenCard(catchText, "LootingCard");
            }
            else
            {
                int goldLost = EventManager.lootPlayer(game.getPlayer());
                
                String outroText = "\nCaptain, they're too strong for us!"
                        + "\nThey took all our cargo, and " + goldLost + " gold!"
                        + "\nWe still have our ship though. Let's sail on.";
                
                // Hand back to the travel card for the next event. 
                frame.getCardsPanel().getTravelCard().triggerEvent(catchText + outroText);
            }
        }
        else 
        {
            String outroText = """
                               She's flying captain, I don't think we can catch her!
                               Let's give up and sail on.
                               """;
        
            // Hand back to the travel card for the next event. 
            frame.getCardsPanel().getTravelCard().triggerEvent(outroText);
        }
    }//GEN-LAST:event_buttonChaseActionPerformed


    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAvoid;
    private javax.swing.JButton buttonChase;
    // End of variables declaration//GEN-END:variables
}
