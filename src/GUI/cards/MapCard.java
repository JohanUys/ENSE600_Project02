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


    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        scrollPaneMap = new javax.swing.JScrollPane();
        comboBoxPortList = new javax.swing.JComboBox<>();
        buttonTravel = new javax.swing.JButton();
        buttonStayInPort = new javax.swing.JButton();
        labelNM = new javax.swing.JLabel();

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

        labelNM.setText("NM = Nautical Mile");

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
                        .addComponent(labelNM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(buttonStayInPort)))
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
                    .addComponent(buttonStayInPort)
                    .addComponent(labelNM))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    // When the 'travel' button is clicked, the player travels to the port. 
    private void buttonTravelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTravelActionPerformed

        // Get the object from the combo box
        Object destinationObject = comboBoxPortList.getSelectedItem();
        
        // Get the destination from that object
        Port destination = game.getMap().getPorts().get((String) destinationObject);
        if (destination == null) {return;}
        
        // Hand over to travel card to handle the travel. 
        frame.getCardsPanel().getTravelCard().setDestination(destination);
        frame.getCardsPanel().getTravelCard().leavePort();
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
    private javax.swing.JLabel labelNM;
    private javax.swing.JScrollPane scrollPaneMap;
    // End of variables declaration//GEN-END:variables
}

