
package GUI.cards;

import GUI.*;
import LOGIC.*;

public class TravelPanel extends javax.swing.JPanel {
    
    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;
    
    
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
        
        //cardsPanel.showCard("PortPanel");
    }
    
    
    public final void write(String message)
    {
        textAreaTravel.setText(""); // Clear text area for typing effect
        
        //Type the entire message
        for(int i = 0 ; i<message.length() ; i++)
        {
            textAreaTravel.append(String.valueOf(message.charAt(i)));
            
            delay();
        }
    }
    
    private void delay()
    {
        //Delay
        try
        {
            Thread.sleep(20);
        }
        catch(InterruptedException err)
        {
            System.out.println("Error in thread sleeping!");
        }
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
