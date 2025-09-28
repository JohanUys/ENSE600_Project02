
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.events.StormEvent;

public class EventStormCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private StormEvent event;
    
    // CONSTRUCTOR =============================================================
    public EventStormCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    // GETTERS & SETTERS =======================================================
    public void setEvent(Events event) {this.event = (StormEvent)event;}
    public Events getEvent() {return event;}
    
    // METHODS =================================================================
    public void updateDisplay()
    {
        labelStormChance.setText("Chance of storm damaging ship: " + EventManager.stormChance(game.getPlayer().getShip()) + "%");
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonFaceStorm = new javax.swing.JButton();
        labelStormChance = new javax.swing.JLabel();

        buttonFaceStorm.setText("Sail Into the Storm!");
        buttonFaceStorm.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonFaceStormActionPerformed(evt);
            }
        });

        labelStormChance.setText("Chance of storm damaging ship: " + EventManager.stormChance(game.getPlayer().getShip()) + "%"
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(buttonFaceStorm)
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelStormChance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(labelStormChance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonFaceStorm)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // COMPONENT METHODS =======================================================
    private void buttonFaceStormActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonFaceStormActionPerformed
    {//GEN-HEADEREND:event_buttonFaceStormActionPerformed
        
        String outroText;
        
        //If storm succeeds, ship is damaged. Else, sail on.
        if(EventManager.storm(game.getPlayer().getShip()))
        {
            int goldLost = EventManager.lootPlayer(game.getPlayer());
            
            outroText = "Captain! The mainmast has snapped!"
                    + "\nWe're taking on water! Throw all cargo overboard!"
                    + "\nPhew, we made it! Repairs will be about " + goldLost + " gold, captain!"
                    + "\nAlright, let's keep going.";
        }
        else
        {
            outroText = """
                        We made it captain!
                        I never once doubted you!
                        Full sail, let's keep going!
                        """;
        }
        
        // Hand back to the travel card for the next event. 
        frame.getCardsPanel().getTravelCard().triggerEvent(outroText);
        
    }//GEN-LAST:event_buttonFaceStormActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFaceStorm;
    private javax.swing.JLabel labelStormChance;
    // End of variables declaration//GEN-END:variables
}
