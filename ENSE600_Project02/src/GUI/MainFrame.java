package GUI;

import LOGIC.Game;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    // PROPERTIES ==============================================================
    private final Game game;
    
    private final CardsPanel cardsPanel;
    private final PlayerPanel playerPanel;
    
    // CONSTRUCTOR =============================================================
    public MainFrame() 
    {
        initComponents();
        setLayout(new BorderLayout());
        
        //Initialize a game to store all of the game data and objects
        game = new Game();
        
        //Initialize the panels that will be added to the MainFrame 
        cardsPanel = new CardsPanel(this);
        playerPanel = new PlayerPanel(this);
        
        //Add the panels to the MainFrame 
        add(cardsPanel, BorderLayout.WEST);
        add(playerPanel, BorderLayout.EAST);
        
        //Set player panel to be initially invisible
        playerPanel.setVisible(false);
    }
    
    // METHODS =================================================================
    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    // AUTO GENERATED ==========================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainFrameMenuBar = new javax.swing.JMenuBar();
        menuBarFile = new javax.swing.JMenu();
        menuBarEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBarFile.setText("File");
        mainFrameMenuBar.add(menuBarFile);

        menuBarEdit.setText("Edit");
        mainFrameMenuBar.add(menuBarEdit);

        setJMenuBar(mainFrameMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                //Runs MainFrame constructor. This is the entry point to thep program
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // GETTERS =================================================================
    public Game getGame() {return this.game;}
    public CardsPanel getCardsPanel() {return this.cardsPanel;}
    public PlayerPanel getPlayerPanel() {return this.playerPanel;}
    
    // AUTO GENERATED ==========================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mainFrameMenuBar;
    private javax.swing.JMenu menuBarEdit;
    private javax.swing.JMenu menuBarFile;
    // End of variables declaration//GEN-END:variables
}
