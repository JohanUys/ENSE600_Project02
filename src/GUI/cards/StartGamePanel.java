package GUI.cards;

import GUI.*;
import LOGIC.*;

public class StartGamePanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final CardsPanel cardsPanel;
    private final Game game;

    // CONSTRUCTOR =============================================================
    public StartGamePanel(CardsPanel cardsPanel, Game game) 
    {
        this.game = game;
        this.cardsPanel = cardsPanel;
        initComponents();
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNewGame = new javax.swing.JButton();
        buttonLoadGame = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        buttonNewGame.setText("New Game");
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGameActionPerformed(evt);
            }
        });

        buttonLoadGame.setText("Load Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(buttonNewGame)
                .addGap(32, 32, 32)
                .addComponent(buttonLoadGame)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLoadGame)
                    .addComponent(buttonNewGame))
                .addContainerGap(578, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // COMPONENT METHODS =======================================================
    //New Game button clicked
    private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
        cardsPanel.showCard("PortPanel"); // Show port card and trigger visibility in showCard()
        cardsPanel.getMainFrame().getDialoguePanel().displayText("""
        Welcome to the high seas, captain!
        Yer first ship awaits! A basic cutter, but she'll serve you well.
        You'll start in the beautiful port of Rhymek!
        Check out the market, and see what's for sale!
        Buy some cheap goods, then travel to distant ports to sell them!
        Beware: the sea is dangerous. If you're out there for too long, 
        who knows what'll happen! If you're feeling brave, take up 
        privateering and capture some enemy ships!

        Now... If you are ready, press the 'enter' key to continue...
    """);
        
    cardsPanel.getMainFrame().getDialoguePanel().requestFocusInWindow();   // Ensure it has focus to receive keys
    cardsPanel.getMainFrame().getDialoguePanel().repaint();
    cardsPanel.getMainFrame().getDialoguePanel().revalidate();
    }//GEN-LAST:event_buttonNewGameActionPerformed

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLoadGame;
    private javax.swing.JButton buttonNewGame;
    // End of variables declaration//GEN-END:variables
}
