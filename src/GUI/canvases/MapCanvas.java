package GUI.canvases;

import LOGIC.*;

import java.awt.*;

public class MapCanvas extends javax.swing.JPanel {

    // Properties ==============================================================
    private final Map map;
    private Port currentPort;
    private final int OFFSET = 100; //To keep ports from going off the page
    
    Color waterColor = new Color(28,75,105);
    Color portColor = new Color(29,110,37);
    Color selectedPortColor = new Color(48,194,80);
    Color lineColor = new Color(10,90,122);
    Color textColor = Color.WHITE;
    
    // Constructor =============================================================
    public MapCanvas(Map map) {
        this.map = map;
        this.setBackground(waterColor);
        this.setPreferredSize(new Dimension(1200, 1200));

        initComponents();
    }
    
    // Methods =================================================================
    public void setCurrentPort(Port port) {
        this.currentPort = port;
        repaint(); // refresh the canvas to highlight the selected port
    }
    
    // Method used to draw the map - More info on https://math.hws.edu/eck/cs124/javanotes7/c6/s2.html
    @Override
    protected void paintComponent(Graphics g) {
        // Always call super.paintComponent to ensure the panel is properly rendered
        super.paintComponent(g);

        // Retrieve the map of ports (keyed by port name)
        java.util.HashMap<String, Port> ports = map.getPorts();

        // Cast Graphics to Graphics2D for advanced drawing features
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // A set to keep track of port pairs for which we have already drawn connecting lines
        java.util.HashSet<String> drawnPairs = new java.util.HashSet<>();

        // Nested loops to iterate over all pairs of ports to draw lines between them
        for (java.util.Map.Entry<String, Port> entry1 : ports.entrySet()) {
            Port port1 = entry1.getValue();         // First port in the pair
            String name1 = port1.getName();         // Name of the first port

            for (java.util.Map.Entry<String, Port> entry2 : ports.entrySet()) {
                Port port2 = entry2.getValue();     // Second port in the pair
                String name2 = port2.getName();     // Name of the second port

                // Avoid drawing a line from a port to itself
                if (!name1.equals(name2)) {

                    // Create a unique key representing the pair of ports in alphabetical order
                    // This prevents drawing the same connection twice in opposite directions
                    String pairKey = name1.compareTo(name2) < 0 ? name1 + "-" + name2 : name2 + "-" + name1;

                    // Only draw the line if this pair hasn't been drawn yet
                    if (!drawnPairs.contains(pairKey)) {
                        // Mark this pair as drawn
                        drawnPairs.add(pairKey);

                        // Set the drawing color to gray for the connection lines
                        g2d.setColor(lineColor);

                        // Draw a line between the two ports using their longitude and latitude as coordinates
                        g2d.drawLine(port1.getLongitude(), port1.getLatitude()+OFFSET, port2.getLongitude(), port2.getLatitude()+OFFSET);
                    }
                }
            }
        }

        // Diameter of the circle used to represent each port on the map
        int portDiameter = 12;

        // Iterate over all ports to draw their representation and labels
        for (Port port : ports.values()) {
            // Calculate the top-left x and y coordinates for the circle so it's centered on the port location
            int x = port.getLongitude() - portDiameter / 2;
            int y = port.getLatitude() - portDiameter / 2 + OFFSET;
            
            // Set color of the port circle:
            // Red if this port is the current active port, otherwise blue
            g2d.setColor((currentPort != null && port.getName().equals(currentPort.getName())) ? selectedPortColor : portColor);

            // Draw the filled circle representing the port
            g2d.fillOval(x, y, portDiameter, portDiameter);

            // Set color to black for the port name text
            g2d.setColor(textColor);
            
            // If the port isn't the current port, draw the name & direction
            // Else just draw the name
            if(port != currentPort) 
            {
                Direction direction = map.calculatePortDirection(currentPort.getName(), port.getName());
            
                // Draw the port name just above the circle
                g2d.drawString(port.getName() + " (" + direction.getName() + ")", x, y - 5);
            }
            else
            {
                // Draw the port name just above the circle
                g2d.drawString(port.getName(), x, y - 5);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMinimumSize(new java.awt.Dimension(1200, 1200));
        setPreferredSize(new java.awt.Dimension(1500, 1500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
