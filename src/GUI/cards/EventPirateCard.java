
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.events.PirateEvent;

public class EventPirateCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private PirateEvent event;
    
    // CONSTRUCTOR =============================================================
    public EventPirateCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    // GETTERS & SETTERS =======================================================
    public void setEvent(Events event) {this.event = (PirateEvent)event;}
    public Events getEvent() {return event;}
    
    // METHODS =================================================================
    public void updateDisplay()
    {
        //Set the buttons to become clickable
        runButton.setEnabled(true);
        fightButton.setEnabled(true);
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        runButton = new javax.swing.JButton();
        fightButton = new javax.swing.JButton();

        runButton.setText("Run!");
        runButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                runButtonActionPerformed(evt);
            }
        });

        fightButton.setText("Fight!");
        fightButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(runButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(fightButton)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(fightButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // COMPONENT METHODS =======================================================
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_runButtonActionPerformed
    {//GEN-HEADEREND:event_runButtonActionPerformed
        //Set the buttons to become unclickable
        runButton.setEnabled(false);
        fightButton.setEnabled(false);
        
        Ship playerShip = game.getPlayer().getShip();
        Ship pirateShip = event.getPirateShip();
        
        // If the pirate ship catches the player ship, then fight.
        if(EventManager.chase(pirateShip, playerShip))
        {
            String catchText = """
                               It's no good, captain! They've caught up!
                               We have no choice! Fight to the death!
                               """;
            
            if(EventManager.fight(playerShip, pirateShip))
            {
                //Give the merchant ship to the looting card
                frame.getCardsPanel().getLootingCard().setLootedShip(pirateShip);
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
                               She's pulling away captain! 
                               Excellent sailing!
                               """;
            
            // Hand back to the travel card for the next event. 
            frame.getCardsPanel().getTravelCard().triggerEvent(outroText);
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void fightButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fightButtonActionPerformed
    {//GEN-HEADEREND:event_fightButtonActionPerformed
        //Set the buttons to become unclickable
        runButton.setEnabled(false);
        fightButton.setEnabled(false);
        
        Ship playerShip = game.getPlayer().getShip();
        Ship pirateShip = event.getPirateShip();
        
        String fightText =  """
                            All right lads! For death and glory!
                            Strike mainsails! Roll out all guns!
                            """;
            
        if(EventManager.fight(playerShip, pirateShip))
        {
            //Give the merchant ship to the looting card
            frame.getCardsPanel().getLootingCard().setLootedShip(pirateShip);
            //Hand over to the looting card
            frame.getDialoguePanel().displayTextThenCard(fightText, "LootingCard");
        }
        else
        {
            int goldLost = EventManager.lootPlayer(game.getPlayer());

            String outroText = "\nCaptain, they're too strong for us!"
                                + "\nThey took all our cargo, and " + goldLost + " gold!"
                                + "\nWe still have our ship though. Let's sail on.";

            // Hand back to the travel card for the next event. 
            frame.getCardsPanel().getTravelCard().triggerEvent(fightText + outroText);
        }
    }//GEN-LAST:event_fightButtonActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fightButton;
    private javax.swing.JButton runButton;
    // End of variables declaration//GEN-END:variables
}
