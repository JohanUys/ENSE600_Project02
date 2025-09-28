
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.events.PirateEvent;

public class EventPirateCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private PirateEvent event;
    
    // CONSTRUCTOR =============================================================
    public EventPirateCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    // SETTERS =================================================================
    public void setEvent(Events event) {this.event = (PirateEvent)event;}
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        runButton = new javax.swing.JButton();
        fightButton = new javax.swing.JButton();

        runButton.setText("Run!");

        fightButton.setText("Fight!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(runButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(fightButton)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(fightButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fightButton;
    private javax.swing.JButton runButton;
    // End of variables declaration//GEN-END:variables
}
