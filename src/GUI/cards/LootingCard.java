
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.ships.Cutter;
import javax.swing.DefaultListModel;

public class LootingCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private Ship lootedShip;
    private boolean isDumping = false;
    
    // CONSTRUCTOR =============================================================
    public LootingCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        
        //Initialize the looted ship. This will change before it is read.
        lootedShip = new Cutter(); 
        
        initComponents();
    }
    
    // SETTER ==================================================================
    public void setLootedShip(Ship lootedShip) {this.lootedShip = lootedShip;}
    public Ship getLootedShip() {return lootedShip;}
    public boolean getIsDumping() {return isDumping;}
    
    // METHODS =================================================================
    public final void updateDisplay()
    {
        labelLootedShip.setText(lootedShip.getName());
        labelLootedShipDescription.setText(lootedShip.getGuns() + " guns, " + lootedShip.getMaxSpeed() + " knots, " + lootedShip.getMaxHoldSpace() + " hold space, worth " + lootedShip.getPrice() + "$");
        
        //Initialize a default list model to store the goods
        DefaultListModel<String> dlm = new DefaultListModel();
        //Add each good into the default list model
        for(Good g : lootedShip.getHold())
        {
            dlm.addElement(g.getName() + " (Maximum price : " + (int)g.getMaxPrice() + ")");
        }
        //Set the list to default list model.
        listLootedShipHold.setModel(dlm);
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        listLootedShipHold = new javax.swing.JList<>();
        labelLootedShip = new javax.swing.JLabel();
        buttonSwapShips = new javax.swing.JButton();
        buttonContinueSailing = new javax.swing.JButton();
        labelIsDumping = new javax.swing.JLabel();
        buttonIsDumping = new javax.swing.JButton();
        labelLootedShipDescription = new javax.swing.JLabel();

        listLootedShipHold.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listLootedShipHoldMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listLootedShipHold);

        labelLootedShip.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelLootedShip.setText(lootedShip.getName());

        buttonSwapShips.setText("Swap Ships!");
        buttonSwapShips.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonSwapShipsActionPerformed(evt);
            }
        });

        buttonContinueSailing.setText("Continue Sailing");
        buttonContinueSailing.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonContinueSailingActionPerformed(evt);
            }
        });

        labelIsDumping.setText("Transferring Cargo!");

        buttonIsDumping.setText("Dump Cargo");
        buttonIsDumping.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonIsDumpingActionPerformed(evt);
            }
        });

        labelLootedShipDescription.setText(lootedShip.getGuns() + " guns, " + lootedShip.getMaxSpeed() + " knots, " + lootedShip.getMaxHoldSpace() + " hold space, worth " + lootedShip.getPrice() + "$"
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSwapShips)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonContinueSailing)
                        .addGap(23, 23, 23))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonIsDumping)
                        .addGap(40, 40, 40)
                        .addComponent(labelIsDumping))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLootedShip)
                        .addGap(18, 18, 18)
                        .addComponent(labelLootedShipDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLootedShip)
                    .addComponent(labelLootedShipDescription))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIsDumping)
                    .addComponent(buttonIsDumping))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonContinueSailing)
                    .addComponent(buttonSwapShips))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listLootedShipHoldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listLootedShipHoldMouseClicked
    {//GEN-HEADEREND:event_listLootedShipHoldMouseClicked
        //Find index of good to take
        int index = listLootedShipHold.getSelectedIndex();
        
        String message;
        
        if(!isDumping) //Looting card is in transferring mode
        {
            //Transfer that good from the lootedShip to the playerShip.  
            message = EventManager.transfer(index, lootedShip, game.getPlayer().getShip()); 
        }
        else //Looting card is in dumping mode
        {
            message = EventManager.dump(index, lootedShip);
        }

        
        //If an error message found, display that error message
        if(message != null)
        {
            //Display message to user.
            frame.displayMessage(message);
        }
        
        //Update displays
        updateDisplay();
        frame.getPlayerPanel().updateDisplay();
    }//GEN-LAST:event_listLootedShipHoldMouseClicked

    private void buttonSwapShipsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonSwapShipsActionPerformed
    {//GEN-HEADEREND:event_buttonSwapShipsActionPerformed
        
        lootedShip = EventManager.swapShips(game.getPlayer(), lootedShip);
        
        //Update displays
        updateDisplay();
        frame.getPlayerPanel().updateDisplay();     
    }//GEN-LAST:event_buttonSwapShipsActionPerformed

    private void buttonIsDumpingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonIsDumpingActionPerformed
    {//GEN-HEADEREND:event_buttonIsDumpingActionPerformed
        
        if(!isDumping)
        {
            isDumping = true;
            buttonIsDumping.setText("Transfer Cargo");
            labelIsDumping.setText("Dumping Cargo!");
        }
        else if(isDumping)
        {
            isDumping = false;
            buttonIsDumping.setText("Dump Cargo");
            labelIsDumping.setText("Transferring Cargo!");
        } 
    }//GEN-LAST:event_buttonIsDumpingActionPerformed

    private void buttonContinueSailingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonContinueSailingActionPerformed
    {//GEN-HEADEREND:event_buttonContinueSailingActionPerformed
        String outroText = "Right, let's sail on!";
        
        frame.getCardsPanel().getTravelCard().triggerEvent(outroText);
    }//GEN-LAST:event_buttonContinueSailingActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonContinueSailing;
    private javax.swing.JButton buttonIsDumping;
    private javax.swing.JButton buttonSwapShips;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIsDumping;
    private javax.swing.JLabel labelLootedShip;
    private javax.swing.JLabel labelLootedShipDescription;
    private javax.swing.JList<String> listLootedShipHold;
    // End of variables declaration//GEN-END:variables
}
