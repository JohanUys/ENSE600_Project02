
package GUI.cards;

import GUI.*;
import LOGIC.*;
import javax.swing.DefaultListModel;

public class ShipyardPanel extends javax.swing.JPanel {
    
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
        //Initialize a default list model to store the ships
        DefaultListModel<String> dlm = new DefaultListModel();
        //For Each ship
        for(Ship s : game.getPort().getShipyard().getShips())
        {
            //Get ship properties
            String name = s.getName();
            int price = s.getPrice();
            int maxSpeed = s.getMaxSpeed();
            int maxHoldSpace = s.getMaxHoldSpace();
            int guns = s.getGuns();

            dlm.addElement(name + " : $" + price + " (Speed: " + maxSpeed + ", Hold Space: " + maxHoldSpace + ", Guns: " + guns + ")");
        }
        //Set the list to default list model.
        listShips.setModel(dlm);
    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonLeaveShipyard = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listShips = new javax.swing.JList<>();
        labelPortShipyard = new javax.swing.JLabel();

        buttonLeaveShipyard.setText("Leave Shipyard");
        buttonLeaveShipyard.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonLeaveShipyardActionPerformed(evt);
            }
        });

        listShips.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listShipsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listShips);

        labelPortShipyard.setText(game.getPort().getName() + " Shipyard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLeaveShipyard)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPortShipyard))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelPortShipyard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonLeaveShipyard)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // COMPONENT METHODS =======================================================
    private void buttonLeaveShipyardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonLeaveShipyardActionPerformed
    {//GEN-HEADEREND:event_buttonLeaveShipyardActionPerformed
        cardsPanel.showCard("PortPanel");
    }//GEN-LAST:event_buttonLeaveShipyardActionPerformed

    private void listShipsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listShipsMouseClicked
    {//GEN-HEADEREND:event_listShipsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listShipsMouseClicked
   
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLeaveShipyard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPortShipyard;
    private javax.swing.JList<String> listShips;
    // End of variables declaration//GEN-END:variables
}
