package GUI.panels;

import GUI.*;
import LOGIC.*;

import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class DialoguePanel extends javax.swing.JPanel {

    // PROPERTIES ==============================================================
    private final MainFrame frame;
    private final Game game;
    
    private static final int TEXTSPEED = 30; //milliseconds per letter
    private int currentIndex;
    private String currentText;
    private Timer timer;
    
    // CONSTRUCTOR =============================================================
    public DialoguePanel(MainFrame frame) {
        this.frame = frame;
        this.game = frame.getGame();
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
        
        
        timer = new Timer(TEXTSPEED, (ActionEvent e) -> {
            if (currentIndex < currentText.length()) {
                textAreaDialogue.append(String.valueOf(currentText.charAt(currentIndex)));
                currentIndex++;
            } else {
                timer.stop();
            }
        });

        timer.start();
    }
    
    // Display text using a 'typing' style. Show a card when the text is finished. 
    public void displayTextThenCard(String displayString, String cardToShow) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        currentIndex = 0;
        currentText = displayString;
        textAreaDialogue.setText("");
        

        timer = new Timer(TEXTSPEED, (ActionEvent e) -> {
            if (currentIndex < currentText.length()) {
                textAreaDialogue.append(String.valueOf(currentText.charAt(currentIndex)));
                currentIndex++;
            } else {
                timer.stop();
                frame.getCardsPanel().showCard(cardToShow);
            }
        });

        timer.start();
    }
    
    // Display the intro text of cards. This function is called in the CardsPanel.showCard() method.
    public void displayCardShownText(String name)
    {
        String text = null;
        
        if(name.equals("StartCard"))
        {
            text =  """
                    Welcome to the high seas, captain! Your first ship awaits!
                    A basic cutter, but she'll serve you well. 
                    Start a new Game!
                    """;
        }
        if(name.equals("PortCard"))
        {
            text = "Welcome to " + game.getPort().getName() + "!"
                    + "\nCheck out the market and see what's for sale,"
                    + "\nor walk over to the shipyard and buy yourself a new ship!"
                    + "\nWhen you're finished in " + game.getPort().getName() + ","
                    + "\nhave a look at your map, and set sail!";
        }
        if(name.equals("MarketCard"))
        {
            text = """
                   This is the market!
                   Try to buy goods for a cheap price, and sell them for a higher price!
                   You can see what the maximum selling price of a good is! 
                   The prices in each port will always stay the same,
                   inflation hasn't been invented yet.
                   """;
        }
        if(name.equals("ShipyardCard"))
        {
            text = """
                   This is where you can trade in your ship for a better one!
                   Or a worse one, if you want.
                   When you buy a ship, 
                   the price of your current ship will be subtracted from what you need to spend!
                   The cargo in your hold will transfer over to your new ship, so no need to worry!
                   """;
        }
        if(name.equals("MapCard"))
        {
            text = """
                   Look at all those distant ports we could travel to!
                   The time it takes to travel will be effected by the following factors:
                   - Wind speed 
                     (Faster the better)
                   - Wind direction 
                     (Try to sail away from the wind direction)
                   - Ship speed 
                     (The faster your ship is, the faster you'll get there. It's pretty obvious really)
                   - Distance to port 
                     (If you go sailing half way across the world, don't expect to get there overnight, yeah?)
                   
                   The longer it takes you to travel, the more likely you are to bump into other ships. 
                   Most of them are friendly...
                   
                   There are also storms... Those aren't fun. 
                   """;
        }
        if(name.equals("EventMerchantCard"))
        {
            text = frame.getCardsPanel().getEventMerchantCard().getEvent().getIntroText();
        }
        if(name.equals("EventPirateCard"))
        {
            text = frame.getCardsPanel().getEventPirateCard().getEvent().getIntroText();
        }
        if(name.equals("EventStormCard"))
        {
            text = frame.getCardsPanel().getEventStormCard().getEvent().getIntroText();
        }
        if(name.equals("LootingCard"))
        {
            text = """
                   Victory! The ship is ours!
                   Now, take whatever cargo you want from the captured ship. 
                   Dump any cargo you don't need from your hold into the ocean.
                   You can even take the ship itself!
                   """;
        }
        
        //Display the message. 
        if(text != null) {displayText(text);}
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
