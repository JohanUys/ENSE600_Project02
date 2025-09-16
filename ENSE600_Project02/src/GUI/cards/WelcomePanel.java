package GUI.cards;

import GUI.*;
import LOGIC.*;

import java.awt.event.*;
import javax.swing.*;

public class WelcomePanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;
    
    
    private Timer timer;
    private int currentIndex;
    private final String fullText = 
            """
            Welcome to the high seas, captain!
            Yer first ship awaits! A basic cutter, but she'll serve you well.
            You'll start in the beautiful port of Rhymek!
            Check out the market, and see what's for sale!
            Buy some cheap goods, then travel to distant ports to sell them!
            Beware: the sea is dangerous. If you're out there for too long, 
            who knows what'll happen! If you're feeling brave, take up 
            privateering and capture some enemy ships!
            
            Now... If you are ready, press the 'enter' key to continue...
            """;

    // CONSTRUCTOR =============================================================
    public WelcomePanel(CardsPanel cardsPanel, Game game) {

        this.game = game;
        this.cardsPanel = cardsPanel;
        initComponents();
        
        currentIndex = 0;
         
        textAreaWelcome.setText(""); // Clear text area for typing effect

        // Timer happens every 50 milliseconds (adjust for text speed)
        timer = new Timer(50, (ActionEvent e) -> {
            // Add one character at a time
            if (currentIndex < fullText.length()) {
                textAreaWelcome.append(String.valueOf(fullText.charAt(currentIndex)));
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
        textAreaWelcome = new javax.swing.JTextArea();

        textAreaWelcome.setEditable(false);
        textAreaWelcome.setColumns(20);
        textAreaWelcome.setLineWrap(true);
        textAreaWelcome.setRows(5);
        textAreaWelcome.setWrapStyleWord(true);
        textAreaWelcome.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                textAreaWelcomeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textAreaWelcome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // COMPONENT METHODS =======================================================
    // Enter key pressed. Full text shown and transition to StartGame panel 
    private void textAreaWelcomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaWelcomeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        if (timer.isRunning()) {
            // Stop timer and show full text immediately
            timer.stop();
            textAreaWelcome.setText(fullText);
        } else {
            // Typing is done, proceed to StartGame panel
            if (cardsPanel != null) {
            cardsPanel.showCard("StartGamePanel");
            } else {
                System.err.println("mainPanel is null!");
            }
        }
        // Consume the event so 'Enter' doesn't add a newline
        evt.consume();
        }
    }//GEN-LAST:event_textAreaWelcomeKeyPressed


    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaWelcome;
    // End of variables declaration//GEN-END:variables
}
