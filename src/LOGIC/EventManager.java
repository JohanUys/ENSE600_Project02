package LOGIC;

import GUI.CardsPanel;
import LOGIC.events.PirateEvent;
import LOGIC.events.StormEvent;
import java.util.List;
import java.util.Random;

public class EventManager {
    private static final double chancePerDay = 10.0; // 10% per day
    private static final int maxEvents = 5;
    
    private static final Random random = new Random();

    private static List<Events> eventsList = List.of(
        new StormEvent(), new PirateEvent()
    );

    public static void triggerEvents(Game game, int travelTimeInHours, CardsPanel cardsPanel) {
        int numEvents = 0;
        int days = travelTimeInHours / 24;

        for (int i = 0; i < days; i++) {
            int roll = random.nextInt(100) + 1; // 1-100
            if (roll <= chancePerDay) {
                Events event = selectRandomEventByWeight();
                if (event != null) {
                    event.trigger(game, cardsPanel);
                    numEvents++;
                }

                if (game.getPlayer().checkGameStatus() == Player.GameStatus.LOSE || numEvents >= maxEvents) {
                    break;
                }
            }
        }
    }


    private static Events selectRandomEventByWeight() {
        int totalWeight = eventsList.stream().mapToInt(Events::getWeighting).sum();
        if (totalWeight == 0) return null;

        int roll = random.nextInt(totalWeight);
        int runningWeight = 0;

        for (Events event : eventsList) {
            runningWeight += event.getWeighting();
            if (roll < runningWeight) {
                return event;
            }
        }
        return null;
    }
}
