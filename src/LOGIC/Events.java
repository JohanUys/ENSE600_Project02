package LOGIC;

import GUI.*;

public interface Events {
    void trigger(Game game, CardsPanel cardsPanel);
    int getWeighting();
}
