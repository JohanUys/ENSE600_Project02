package GUI.cards;

import GUI.canvases.MapCanvas;
import GUI.*;
import LOGIC.*;

import java.awt.Dimension;
import java.awt.Point;

public class MapCard extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private final MapCanvas mapCanvas;

    // CONSTRUCTOR =============================================================
    public MapCard(MainFrame frame) 
    {
        this.frame = frame;
        this.game = frame.getGame();
        
        //Initialize the map canvas
        this.mapCanvas = new MapCanvas(game.getMap());
        
        initComponents();
        
        updateDisplay();
    }

    // METHODS =================================================================
    
    public final void updateDisplay() {
        // Update map canvas and center on destination
        mapCanvas.setCurrentPort(game.getPort());
        centerMapOnPort(game.getPort());
        populatePortComboBox();
        buttonStayInPort.setText("Stay in " + game.getPort().getName());
        repaint();
    }
    
    // Add available ports to combobox
    private void populatePortComboBox() {
        comboBoxPortList.removeAllItems(); // clear current items

        Port currentPort = game.getPort();
        if (currentPort == null) return;

        String currentPortName = currentPort.getName();
        for (String portName : game.getMap().getPorts().keySet()) {
            if (!portName.equals(currentPortName)) {
                comboBoxPortList.addItem(portName);
            }
        }

        // Set the selected item to the first port in the list
        if (comboBoxPortList.getItemCount() > 0) {
            comboBoxPortList.setSelectedIndex(0);
        }
    } 
    
    // Center the scrollpane's viewport on the current port
    private void centerMapOnPort(Port port) {
        if (port == null) return;

        int portX = port.getLongitude();
        int portY = port.getLatitude();

        mapCanvas.revalidate();
        mapCanvas.repaint();
        scrollPaneMap.getViewport().revalidate();
        scrollPaneMap.getViewport().repaint();

        Dimension viewportSize = scrollPaneMap.getViewport().getExtentSize();
        Dimension canvasSize = mapCanvas.getPreferredSize();

        // Center viewport on the port
        int viewX = portX - viewportSize.width / 2;
        int viewY = portY - viewportSize.height / 2;

        // Clamp the view position to stay within canvas bounds
        viewX = Math.max(0, Math.min(viewX, canvasSize.width - viewportSize.width));
        viewY = Math.max(0, Math.min(viewY, canvasSize.height - viewportSize.height));

        scrollPaneMap.getViewport().setViewPosition(new Point(viewX, viewY));
    }

    
    
    
    
    
    // Player travels to the selected port and the map is updated
    private void travelToSelectedPort(Object selectedItem) {
        if (selectedItem == null) return;

        // Get the selected port
        Port selectedPort = game.getMap().getPorts().get((String) selectedItem);
        if (selectedPort == null) return;

        // Capture current port traveling
        Port originPort = game.getPort();

        // THIS STUFF COULD BE DONE IN A TRAVEL PANEL
        
        // Travel
        game.travelToPort(selectedPort);

        

        // Show travel info
        String travelInfo = travelInformationDialogue(originPort, selectedPort);
        frame.getDialoguePanel().displayText(travelInfo);
        
        // Determine travel time
        int travelTimeInHours = game.calculatePortTravelTime(originPort, selectedPort);
        
        // Trigger any events that may occur.
        EventManager.triggerEvents(game, travelTimeInHours, frame.getCardsPanel());
    }


    
    
    // Could be moved to a travel panel 
    // Travel information dialogue
    private String travelInformationDialogue(Port originPort, Port destinationPort) {
        if (originPort == null || destinationPort == null) {
            return "Travel information is unavailable.";
        }

        String originName = originPort.getName();
        String destinationName = destinationPort.getName();

        Wind wind = game.getWind();
        Ship ship = game.getPlayer().getShip();

        int distance = game.getMap().calculatePortDistance(originName, destinationName);
        int travelTimeHours = game.getMap().calculatePortTravelTime(originName, destinationName, wind, ship);

        int days = travelTimeHours / 24;
        int hours = travelTimeHours % 24;

        StringBuilder info = new StringBuilder();
        info.append("You depart from ").append(originName).append(".\n");
        info.append("The wind is blowing ").append(wind.getDirection().getName())
            .append(" at ").append(wind.getSpeed()).append(" knots.\n");
        info.append("You have arrived at ").append(destinationName).append(", a distance of ")
            .append(distance).append(" nautical miles.\n");
        info.append("The journey took: ");

        if (days > 0) {
            info.append(days).append(" day").append(days > 1 ? "s" : "");
            if (hours > 0) info.append(" and ");
        }
        if (hours > 0 || days == 0) {
            info.append(hours).append(" hour").append(hours != 1 ? "s" : "");
        }

        info.append(".\nSafe travels, captain!");
        return info.toString();
    }


    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        scrollPaneMap = new javax.swing.JScrollPane();
        comboBoxPortList = new javax.swing.JComboBox<>();
        buttonTravel = new javax.swing.JButton();
        buttonStayInPort = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(394, 299));

        scrollPaneMap.setViewportView(mapCanvas);

        buttonTravel.setText("Travel");
        buttonTravel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonTravelActionPerformed(evt);
            }
        });

        buttonStayInPort.setText("Stay in " + game.getPort().getName());
        buttonStayInPort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonStayInPortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneMap)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxPortList, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTravel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStayInPort)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneMap, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPortList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTravel)
                    .addComponent(buttonStayInPort))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    // When the 'travel' button is clicked the player panel is updated and the player travels to the selected port
    private void buttonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTravelActionPerformed

        travelToSelectedPort(comboBoxPortList.getSelectedItem()); // Travel to port
        
        //frame.getCardsPanel().showCard("TravelPanel");
    }//GEN-LAST:event_buttonTravelActionPerformed
    
    // When the 'view port' button is clicked the port, market and shipyard panels are updated and the card changes to the current port
    private void buttonStayInPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStayInPortActionPerformed
        
        frame.getCardsPanel().showCard("PortCard");
        
    }//GEN-LAST:event_buttonStayInPortActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStayInPort;
    private javax.swing.JButton buttonTravel;
    private javax.swing.JComboBox<String> comboBoxPortList;
    private javax.swing.JScrollPane scrollPaneMap;
    // End of variables declaration//GEN-END:variables
}

