package GUI.panels;

import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class DialoguePanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private int currentIndex;
    private String currentText;
    private Timer timer;
    
    // CONSTRUCTOR =============================================================
    public DialoguePanel() {
        initComponents();
    }

    // METHODS =================================================================
    
    // Display text using a 'typing' style
    public void displayText(String displayString) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        currentIndex = 0;
        currentText = displayString;
        textAreaDialogue.setText("");
        
        // 50ms between characters
        timer = new Timer(50, (ActionEvent e) -> {
            if (currentIndex < currentText.length()) {
                textAreaDialogue.append(String.valueOf(currentText.charAt(currentIndex)));
                currentIndex++;
            } else {
                timer.stop();
            }
        });

        timer.start();
    }
    
    
    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDialogue = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(10, 180));
        setPreferredSize(new java.awt.Dimension(720, 175));
        setLayout(new java.awt.GridBagLayout());

        textAreaDialogue.setEditable(false);
        textAreaDialogue.setColumns(20);
        textAreaDialogue.setRows(11);
        textAreaDialogue.setMinimumSize(new java.awt.Dimension(13, 180));
        textAreaDialogue.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                textAreaDialogueKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textAreaDialogue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 601;
        gridBagConstraints.ipady = 302;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // EVENTS ==================================================================
    
    // When 'enter' button is hit the dialogue fills immediately, if it is pressed again, the dialogue box empties
    private void textAreaDialogueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaDialogueKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                if (timer != null && timer.isRunning()) {
                    // If still animating, stop and fill text immediately
                    timer.stop();
                    textAreaDialogue.setText(currentText);
                } else {
                    // If already done, clear the dialogue box
                    textAreaDialogue.setText("");
                }
                evt.consume(); // prevent newline
            }
    }//GEN-LAST:event_textAreaDialogueKeyPressed


    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDialogue;
    // End of variables declaration//GEN-END:variables
}
