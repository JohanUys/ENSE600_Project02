package GUI;

import LOGIC.*;
import javax.swing.DefaultListModel;

// PANEL CONTAINING PLAYER INFORMATION
public class PlayerPanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final Game game;
    private final MainFrame frame;
    
    // CONSTRUCTOR =============================================================
    public PlayerPanel(MainFrame frame) 
    {
        //Store frame and game as fields 
        this.frame = frame;
        this.game = frame.getGame();
        
        initComponents();
        updateDisplay();
    }
    
    // GETTERS =================================================================
    public MainFrame getMainFrame() {return this.frame;}
    
    // METHODS =================================================================
    public final void updateDisplay()
    {
        //Update components 
        labelPlayerName.setText(game.getPlayer().getName());
        labelPlayerGold.setText("Gold: $" + String.valueOf(game.getPlayer().getGold()));
        labelPlayerPort.setText("Port: " + String.valueOf(game.getPort().getName()));
        labelMyShip.setText("My " + game.getPlayer().getShip().getName());
        labelShipPrice.setText("Worth: $" + game.getPlayer().getShip().getPrice());
        labelShipGuns.setText("Guns: " + game.getPlayer().getShip().getGuns());
        labelShipMaxSpeed.setText("Max Speed: " + game.getPlayer().getShip().getMaxSpeed() + " knots");
        labelShipHoldSpace.setText("Hold Space: (" + game.getPlayer().getShip().getHold().size() + "/" + game.getPlayer().getShip().getMaxHoldSpace() + ")");
        
        //DISPLAY THE HOLD
        //Initialize a default list model to store the goods
        DefaultListModel<String> dlm = new DefaultListModel();
        //Add each good into the default list model
        for(Good g : game.getPlayer().getShip().getHold())
        {
            int adjustedPrice = g.getAdjustedPrice(game.getPort().getMarket());
            dlm.addElement(g.getName() + " : $" + adjustedPrice + " (Maximum price : " + (int)g.getMaxPrice() + ")");
        }
        //Set the list to default list model.
        listHold.setModel(dlm);
    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPlayerName = new javax.swing.JLabel();
        labelPlayerGold = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listHold = new javax.swing.JList<>();
        labelMyShip = new javax.swing.JLabel();
        labelShipGuns = new javax.swing.JLabel();
        labelShipMaxSpeed = new javax.swing.JLabel();
        labelShipHoldSpace = new javax.swing.JLabel();
        labelShipPrice = new javax.swing.JLabel();
        labelPlayerPort = new javax.swing.JLabel();

        labelPlayerName.setText(game.getPlayer().getName());

        labelPlayerGold.setText("Gold: $" + String.valueOf(game.getPlayer().getGold()));

        listHold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHoldMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listHold);

        labelMyShip.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelMyShip.setText("My " + game.getPlayer().getShip().getName());

        labelShipGuns.setText("Guns: " + game.getPlayer().getShip().getGuns()
        );

        labelShipMaxSpeed.setText("Max Speed: " + game.getPlayer().getShip().getMaxSpeed() + " knots"
        );

        labelShipHoldSpace.setText("Hold Space: (" + game.getPlayer().getShip().getHold().size() + "/" + game.getPlayer().getShip().getMaxHoldSpace() + ")"
        );

        labelShipPrice.setText("Worth: $" + game.getPlayer().getShip().getPrice());

        labelPlayerPort.setText("Port: " + String.valueOf(game.getPort().getName()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMyShip)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelShipHoldSpace)
                                    .addComponent(labelShipPrice))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelShipMaxSpeed)
                                    .addComponent(labelShipGuns)))
                            .addComponent(labelPlayerName)
                            .addComponent(labelPlayerGold)
                            .addComponent(labelPlayerPort))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelPlayerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPlayerGold)
                .addGap(2, 2, 2)
                .addComponent(labelPlayerPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMyShip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShipGuns)
                    .addComponent(labelShipPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShipHoldSpace)
                    .addComponent(labelShipMaxSpeed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    private void listHoldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listHoldMouseClicked
    {//GEN-HEADEREND:event_listHoldMouseClicked
        //If market panel is being displayed
        if(frame.getCardsPanel().isShown("MarketPanel"))
        {
            //Find the index of the item to sell
            int index = listHold.getSelectedIndex();
            //Sell that item
            String message = game.getPort().getMarket().sell(index, game.getPlayer());
            
            //If an error message found, display that error message
            if(message != null)
            {
                frame.displayMessage(message);
            }

            //Update displays
            updateDisplay();
            frame.getCardsPanel().getMarketPanel().updateDisplay();
        }
    }//GEN-LAST:event_listHoldMouseClicked
   
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMyShip;
    private javax.swing.JLabel labelPlayerGold;
    private javax.swing.JLabel labelPlayerName;
    private javax.swing.JLabel labelPlayerPort;
    private javax.swing.JLabel labelShipGuns;
    private javax.swing.JLabel labelShipHoldSpace;
    private javax.swing.JLabel labelShipMaxSpeed;
    private javax.swing.JLabel labelShipPrice;
    private javax.swing.JList<String> listHold;
    // End of variables declaration//GEN-END:variables
}
