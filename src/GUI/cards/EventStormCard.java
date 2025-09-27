
package GUI.cards;

import GUI.*;
import LOGIC.*;
import LOGIC.events.StormEvent;

public class EventStormCard extends javax.swing.JPanel
{
    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private StormEvent event;
    
    // CONSTRUCTOR =============================================================
    public EventStormCard(MainFrame frame)
    {
        this.frame = frame;
        this.game = frame.getGame();
        initComponents();
    }
    
    // METHODS =================================================================
    public void setEvent(Events event)
    {
        this.event = (StormEvent)event;
    }
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonDump = new javax.swing.JButton();
        buttonRisk = new javax.swing.JButton();

        buttonDump.setText("Dump");

        buttonRisk.setText("Risk It");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(buttonDump)
                .addGap(88, 88, 88)
                .addComponent(buttonRisk)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDump)
                    .addComponent(buttonRisk))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDump;
    private javax.swing.JButton buttonRisk;
    // End of variables declaration//GEN-END:variables
}
