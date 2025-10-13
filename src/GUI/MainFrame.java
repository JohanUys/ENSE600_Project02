package GUI;

import GUI.panels.*;
import LOGIC.Game;
import Database.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;

// PROJECT MAIN FRAME
public class MainFrame extends javax.swing.JFrame {

    // PROPERTIES ==============================================================
    private final Game game;
    
    private final PlayerPanel playerPanel;
    private final CardsPanel cardsPanel;
    private final DialoguePanel dialoguePanel;
    
    // CONSTRUCTOR =============================================================
    public MainFrame() {
        initComponents(); // Sets up menu bar
        DBSetup.initDatabase(); // Initialise Database

        // Initialize a game to store all of the game data and the game objects
        game = new Game();
        
        // Initialize the panels that will be added to the mainframe
        playerPanel = new PlayerPanel(this);
        dialoguePanel = new DialoguePanel(this);
        cardsPanel = new CardsPanel(this);

        // Layout manager
        GridBagConstraints gbc = new GridBagConstraints();

        // --------- CardsPanel (75% width, 85% height) ---------
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.weighty = 0.85;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(cardsPanel, gbc);

        // --------- DialoguePanel (75% width, 15% height) ---------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.75;
        gbc.weighty = 0.15;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        getContentPane().add(dialoguePanel, gbc);

        // --------- PlayerPanel (25% width, full height) ---------
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        getContentPane().add(playerPanel, gbc);

        setPreferredSize(new Dimension(960, 720));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Close handled in event listener
    }

    // GETTERS =================================================================
    public Game getGame() {return this.game;}
    public CardsPanel getCardsPanel() {return this.cardsPanel;}
    public PlayerPanel getPlayerPanel() {return this.playerPanel;}
    public DialoguePanel getDialoguePanel() {return this.dialoguePanel;}
    
    // METHODS =================================================================
    public void displayMessage(String message)
    {
        //Displays a popup dialogue box 
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
//    public void showDialogue(String text, Runnable onComplete) {
//        dialoguePanel.displayText(text);
//        dialoguePanel.setVisible(true);
//    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When player exits window, the current wind state is saved and the app is closed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        WindDatabase.saveWind(game.getWind()); // Save current wind
        
        // Exit the app
        System.exit(0);

    }//GEN-LAST:event_formWindowClosing

    // MAIN METHOD =============================================================
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                //Runs MainFrame constructor. This is the entry point to the program
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
