package GUI.panels;

import GUI.MainFrame;
import GUI.canvases.CompassInlayCanvas;
import LOGIC.*;

import java.awt.Color;
import javax.swing.DefaultListModel;

// PANEL CONTAINING PLAYER INFORMATION
public class PlayerPanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private final CompassInlayCanvas compassInlay;
    
    // CONSTRUCTOR =============================================================
    public PlayerPanel(MainFrame frame) 
    {
        //Store frame and game as fields 
        this.frame = frame;
        this.game = frame.getGame();
        
        initComponents();
        
        Color color = new Color(110, 94, 75);
        setBackground(color);
        
        //Draw Compass 
        Wind wind = game.getWind();
        compassInlay = new CompassInlayCanvas(wind);
        CompassInlayPanel.setLayout(new java.awt.BorderLayout());
        CompassInlayPanel.add(compassInlay, java.awt.BorderLayout.CENTER);
        CompassInlayPanel.setBackground(color);
        
        updateDisplay();
    }
    
    // GETTERS =================================================================
    public MainFrame getMainFrame() {return this.frame;}
    public CompassInlayCanvas getCompassInlay() {return compassInlay;}
    
    // METHODS =================================================================
    public final void updateDisplay()
    {
        //Update components 
        labelPlayerName.setText(game.getPlayer().getName());
        labelPlayerGold.setText("Gold: $" + String.valueOf(game.getPlayer().getGold()));
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
            CardsPanel cardsPanel = frame.getCardsPanel();
            
            //If the ship is not travelling, include adjusted price
            if(!  (cardsPanel.isShown("LootingCard") 
                || cardsPanel.isShown("DumpingCard")
                || cardsPanel.isShown("TravelCard")
                || cardsPanel.isShown("EventMerchantCard")
                || cardsPanel.isShown("EventPirateCard")
                || cardsPanel.isShown("EventStormCard"))
              )
            {
                int adjustedPrice = g.getAdjustedPrice(game.getPort().getMarket());
                dlm.addElement(g.getName() + " : $" + adjustedPrice + " (Maximum price : " + (int)g.getMaxPrice() + ")");
            }
            else //Ship is travelling, don't include adjusted price (it makes no sense to have an adjusted price if not in a port)
            {
                dlm.addElement(g.getName() + " (Maximum price : " + (int)g.getMaxPrice() + ")");
            }
        }
        //Set the list to default list model.
        listHold.setModel(dlm);

    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        labelPlayerName = new javax.swing.JLabel();
        labelPlayerGold = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listHold = new javax.swing.JList<>();
        labelMyShip = new javax.swing.JLabel();
        labelShipGuns = new javax.swing.JLabel();
        labelShipMaxSpeed = new javax.swing.JLabel();
        labelShipHoldSpace = new javax.swing.JLabel();
        labelShipPrice = new javax.swing.JLabel();
        CompassInlayPanel = new javax.swing.JPanel();
        labelWind = new javax.swing.JLabel();
        labelWindDetails = new javax.swing.JLabel();

        labelPlayerName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelPlayerName.setText(game.getPlayer().getName());

        labelPlayerGold.setText("Gold: $" + String.valueOf(game.getPlayer().getGold()));

        listHold.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listHoldMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listHold);

        labelMyShip.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelMyShip.setText("My " + game.getPlayer().getShip().getName());

        labelShipGuns.setText("Guns: " + game.getPlayer().getShip().getGuns()
        );

        labelShipMaxSpeed.setText("Max Speed: " + game.getPlayer().getShip().getMaxSpeed() + " knots"
        );

        labelShipHoldSpace.setText("Hold Space: (" + game.getPlayer().getShip().getHold().size() + "/" + game.getPlayer().getShip().getMaxHoldSpace() + ")"
        );

        labelShipPrice.setText("Worth: $" + game.getPlayer().getShip().getPrice());

        javax.swing.GroupLayout CompassInlayPanelLayout = new javax.swing.GroupLayout(CompassInlayPanel);
        CompassInlayPanel.setLayout(CompassInlayPanelLayout);
        CompassInlayPanelLayout.setHorizontalGroup(
            CompassInlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        CompassInlayPanelLayout.setVerticalGroup(
            CompassInlayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        labelWind.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelWind.setText("Wind:");

        labelWindDetails.setText(game.getWind().getSpeed() + " knots from the " + game.getWind().getDirection().name()
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelWind)
                                    .addComponent(labelWindDetails))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CompassInlayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMyShip)
                                    .addComponent(labelPlayerGold)
                                    .addComponent(labelPlayerName)
                                    .addComponent(labelShipHoldSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelShipMaxSpeed))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelShipPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelShipGuns)))
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelPlayerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPlayerGold)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(labelWind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWindDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(CompassInlayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(labelMyShip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShipGuns)
                    .addComponent(labelShipPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShipHoldSpace)
                    .addComponent(labelShipMaxSpeed))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    private void listHoldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listHoldMouseClicked
    {//GEN-HEADEREND:event_listHoldMouseClicked
        //Find the index of the item to sell
        int index = listHold.getSelectedIndex();
        String message = null;

        //If market panel is being displayed
        if(frame.getCardsPanel().isShown("MarketCard"))
        {
            //Sell that item
            message = game.getPort().getMarket().sell(index, game.getPlayer());
            
            //Update displays
            updateDisplay();
            frame.getCardsPanel().getMarketCard().updateDisplay();
        }
        if(frame.getCardsPanel().isShown("LootingCard"))
        {
            Ship playerShip = game.getPlayer().getShip();
            Ship lootedShip = frame.getCardsPanel().getLootingCard().getLootedShip();
            boolean isDumping = frame.getCardsPanel().getLootingCard().getIsDumping();
           
            if(!isDumping) //Looting card is in transferring mode
            {
                //transfer that item
                message = EventManager.transfer(index, playerShip, lootedShip);
            }
            else //Looting card is in dumping mode 
            {
                message = EventManager.dump(index, playerShip);
            }
            
            //Update displays
            updateDisplay();
            frame.getCardsPanel().getLootingCard().updateDisplay();
        }
        if(frame.getCardsPanel().isShown("EventStormCard"))
        {
            Ship playerShip = game.getPlayer().getShip();
            
            //Dump the item
            message = EventManager.dump(index, playerShip);
            
            //Update displays
            updateDisplay();
            frame.getCardsPanel().getEventStormCard().updateDisplay();
        }
        
        //If an error message found, display that error message
        if(message != null)
        {
            frame.displayMessage(message);
        }
    }//GEN-LAST:event_listHoldMouseClicked
   
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CompassInlayPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMyShip;
    private javax.swing.JLabel labelPlayerGold;
    private javax.swing.JLabel labelPlayerName;
    private javax.swing.JLabel labelShipGuns;
    private javax.swing.JLabel labelShipHoldSpace;
    private javax.swing.JLabel labelShipMaxSpeed;
    private javax.swing.JLabel labelShipPrice;
    private javax.swing.JLabel labelWind;
    private javax.swing.JLabel labelWindDetails;
    private javax.swing.JList<String> listHold;
    // End of variables declaration//GEN-END:variables
}
