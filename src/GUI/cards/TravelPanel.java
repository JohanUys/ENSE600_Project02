
package GUI.cards;

import GUI.*;
import LOGIC.*;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class TravelPanel extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;
    
    Timer timer;
    int currentIndex;
    
    // CONSTRUCTOR =============================================================
    public TravelPanel(CardsPanel cardsPanel, Game game)
    {
        this.game = game;
        this.cardsPanel = cardsPanel;
        initComponents();
    }
    
    // METHODS =================================================================
    public void handleTravel()
    {
        String message = "Hello, you have travelled to " + game.getPort().getName();
        
        write(message);
        
        //Johan, if you uncomment this, the main thread will keep going and display the port panel instantly.
        //Timer is a seperate thread that runs concurrently.
        //cardsPanel.showCard("PortPanel");
    }
    
    
    public final void write(String message)
    {
        textAreaTravel.setText(""); // Clear text area for typing effect

        // Timer happens every 50 milliseconds (adjust for text speed)
        timer = new Timer(20, (ActionEvent e) -> {
            // Add one character at a time
            if (currentIndex < message.length()) {
                textAreaTravel.append(String.valueOf(message.charAt(currentIndex)));
                currentIndex++;
            } else {
                // Stop timer when done
                timer.stop();
            }
        });

        // Start typing effect
        timer.start();
    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaTravel = new javax.swing.JTextArea();

        textAreaTravel.setEditable(false);
        textAreaTravel.setColumns(20);
        textAreaTravel.setLineWrap(true);
        textAreaTravel.setRows(5);
        textAreaTravel.setWrapStyleWord(true);
        textAreaTravel.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                textAreaTravelKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textAreaTravel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // COMPONENT METHODS =======================================================
    private void textAreaTravelKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_textAreaTravelKeyPressed
    {//GEN-HEADEREND:event_textAreaTravelKeyPressed
        
    }//GEN-LAST:event_textAreaTravelKeyPressed

    //AUTO GENERATED ===========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaTravel;
    // End of variables declaration//GEN-END:variables
}
