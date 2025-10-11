
package GUI.cards;

import GUI.*;
import LOGIC.*;

import javax.swing.DefaultListModel;

public class MarketCard extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;

    // CONSTRUCTOR =============================================================
    public MarketCard(MainFrame frame) 
    {   
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
        
        updateDisplay();
    }
    
    // METHODS =================================================================
    public final void updateDisplay()
    {
        labelPortMarket.setText(game.getPort().getName() + " Market");
        //Initialize a default list model to store the goods
        DefaultListModel<String> dlm = new DefaultListModel();
        //Add each good into the default list model
        for(Good g : game.getPort().getMarket().getGoods())
        {
            int adjustedPrice = g.getAdjustedPrice(game.getPort().getMarket());
            dlm.addElement(g.getName() + " : $" + adjustedPrice + " (Maximum price : " + (int)g.getMaxPrice() + ")");
        }
        //Set the list to default list model.
        listGoods.setModel(dlm);
    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        labelPortMarket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGoods = new javax.swing.JList<>();
        buttonLeaveMarket = new javax.swing.JButton();

        labelPortMarket.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelPortMarket.setText(game.getPort().getName() + " Market"
        );
        labelPortMarket.setName("labelPortNameMarket"); // NOI18N

        listGoods.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listGoodsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listGoods);

        buttonLeaveMarket.setText("Leave Market");
        buttonLeaveMarket.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonLeaveMarketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLeaveMarket)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labelPortMarket)))
                .addContainerGap(597, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelPortMarket)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonLeaveMarket)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    private void buttonLeaveMarketActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonLeaveMarketActionPerformed
    {//GEN-HEADEREND:event_buttonLeaveMarketActionPerformed
        frame.getCardsPanel().showCard("PortCard");
    }//GEN-LAST:event_buttonLeaveMarketActionPerformed

    private void listGoodsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listGoodsMouseClicked
    {//GEN-HEADEREND:event_listGoodsMouseClicked
        //Find index of item to buy
        int index = listGoods.getSelectedIndex();
        
        if(index >= 0) //Prevents error throwing if market is empty
        {
            //Buy that item 
            String message = game.getPort().getMarket().buy(index, game.getPlayer());

            //If an error message found, display that error message
            if(message != null)
            {
                //Display message to user.
                frame.displayMessage(message);
            }

            //Update displays
            updateDisplay();
            frame.getPlayerPanel().updateDisplay();
        }
    }//GEN-LAST:event_listGoodsMouseClicked

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLeaveMarket;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPortMarket;
    private javax.swing.JList<String> listGoods;
    // End of variables declaration//GEN-END:variables
}
