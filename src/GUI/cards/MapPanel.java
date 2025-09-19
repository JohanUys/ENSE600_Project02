package GUI.cards;

import GUI.canvases.MapCanvas;
import GUI.*;
import LOGIC.*;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.SwingUtilities;

public class MapPanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;
    
    private final PlayerPanel playerPanel;
    private final Map map;
    private final MapCanvas mapCanvas;

    // CONSTRUCTOR =============================================================
    public MapPanel(CardsPanel cardsPanel, Game game) 
    {
        this.game = game;
        this.cardsPanel = cardsPanel;
        
        this.map = game.getMap();
        
        //Initialize the map canvas
        this.mapCanvas = new MapCanvas(map);
        mapCanvas.setCurrentPort(game.getPort());
        
        this.playerPanel = cardsPanel.getMainFrame().getPlayerPanel();
        initComponents();
        if (!map.getPorts().isEmpty()) {
            Port currentPort = game.getPort();
            mapCanvas.setCurrentPort(currentPort);
        }
        populatePortComboBox();
    }

    // METHODS =================================================================
    // Add available ports to combobox
    private void populatePortComboBox() {
        comboBoxPortList.removeAllItems(); // clear current items

        Port currentPort = game.getPort();
        if (currentPort == null) return;

        String currentPortName = currentPort.getName();
        for (String portName : map.getPorts().keySet()) {
            if (!portName.equals(currentPortName)) {
                comboBoxPortList.addItem(portName);
            }
        }

        // Set the selected item to the first port in the list
        if (comboBoxPortList.getItemCount() > 0) {
            comboBoxPortList.setSelectedIndex(0);
        }
    } 

    // Player travels to the selected port and the map is updated
    private void travelToSelectedPort(Object selectedItem) {
        if (selectedItem == null) return;
        Port selectedPort = map.getPorts().get((String) selectedItem);
        centerMapOnPort(selectedPort);
        if (selectedPort == null) return;

        game.travelToPort(selectedPort);

        // Update the map canvas highlight
        mapCanvas.setCurrentPort(selectedPort);
        
        // Center map on current port
        centerMapOnPort(selectedPort);

        // Refresh UI
        repaint();
    }
    
    // Center the scrollpane's viewport on the initial port
    public void centerMapOnInitialPort() {
        if (!map.getPorts().isEmpty()) {
            Port currentPort = game.getPort();
            mapCanvas.setCurrentPort(currentPort);

            // Use invokeLater to ensure layout is done before centering
            SwingUtilities.invokeLater(() -> centerMapOnPort(currentPort));
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

//    // Add distances and travel times from the player's current port to other ports to the text area
//    private void updateDistanceList() {
//        Port currentPort = game.getPort();
//        if (currentPort == null) return;
//
//        String currentPortName = currentPort.getName();
//        java.util.HashMap<String, Port> allPorts = map.getPorts();
//
//        // Get wind and ship informatuion for travel time
//        Wind currentWind = game.getWind();
//        Ship currentShip = game.getPlayer().getShip();
//
//        StringBuilder distanceText = new StringBuilder();
//        distanceText.append("Port Distances:\n");
//
//        // Append distance and travel times for each available port
//        for (String portName : allPorts.keySet()) {
//            if (!portName.equals(currentPortName)) {
//                int distance = map.calculatePortDistance(currentPortName, portName);
//                int travelTimeHours = map.calculatePortTravelTime(currentPortName, portName, currentWind, currentShip);
//
//                int days = travelTimeHours / 24;
//                int hours = travelTimeHours % 24;
//
//                distanceText.append(portName)
//                            .append(": ")
//                            .append(distance)
//                            .append(" nmi.")
//                            .append(" Travel time: ");
//
//                // Build day(s)/hour(s) string depending on the values
//                if (days > 0) {
//                    distanceText.append(days)
//                                .append(" day")
//                                .append(days > 1 ? "s" : "");
//
//                    if (hours > 0) {
//                        distanceText.append(" and ");
//                    }
//                }
//
//                if (hours > 0 || days == 0) {
//                    distanceText.append(hours)
//                                .append(" hour")
//                                .append(hours != 1 ? "s" : "");
//                }
//
//                distanceText.append(".\n");
//            }
//        }
//
//        textAreaDistanceList.setText(distanceText.toString());
//    }
    
//    // Add the player's travel information to the dialogue text area
//    public void updateTravelDialogue(String currentPortName, Wind wind, String destinationPortName) {
//        textAreaTravelDialogue.setText(""); // clear previous dialogue
//
//        textAreaTravelDialogue.append("You set sail from " + currentPortName + ".\n");
//        textAreaTravelDialogue.append("The wind is blowing " + wind.getDirection().getName() + " at " + wind.getSpeed() + " knots.\n");
//        textAreaTravelDialogue.append("You arrive at " + destinationPortName + " after a smooth voyage.\n");
//    }


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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneMap, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonTravel)
                            .addComponent(comboBoxPortList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonStayInPort))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPaneMap, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(buttonTravel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxPortList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(buttonStayInPort)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    // When the 'travel' button is clicked the player panel is updated and the player travels to the selected port
    private void buttonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTravelActionPerformed

        travelToSelectedPort(comboBoxPortList.getSelectedItem()); // Travel to port
        populatePortComboBox();// Update available ports
        // Update compass
        playerPanel.updateDisplay();
        playerPanel.getCompassInlay().repaint();
        buttonStayInPort.setText("Stay in " + game.getPort().getName());
        
        cardsPanel.showCard("TravelPanel");
    }//GEN-LAST:event_buttonTravelActionPerformed
    
    // When the 'view port' button is clicked the port, marlet and shipyard panels are updated and the card changes to the current port
    private void buttonStayInPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStayInPortActionPerformed
        cardsPanel.showCard("PortPanel");
        cardsPanel.updateAllPanels();
    }//GEN-LAST:event_buttonStayInPortActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStayInPort;
    private javax.swing.JButton buttonTravel;
    private javax.swing.JComboBox<String> comboBoxPortList;
    private javax.swing.JScrollPane scrollPaneMap;
    // End of variables declaration//GEN-END:variables
}

