package LOGIC;

import GUI.panels.CardsPanel;
import GUI.*;

public interface Events {
    void trigger(Game game, CardsPanel cardsPanel);
    int getWeighting();
}
