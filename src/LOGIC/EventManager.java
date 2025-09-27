package LOGIC;

import LOGIC.events.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventManager {
    private static final double CHANCEPERDAY = 10.0; // 10% per day
    private static final int MAXEVENTS = 5;
    
    private static final Random random = new Random();

    private static final List<Events> eventsList = List.of(
        new MerchantEvent(), new StormEvent(), new PirateEvent()
    );

    public static ArrayList<Events> generateEvents(Game game, int travelTimeInHours) {
        int numEvents = 0;
        int days = travelTimeInHours / 24;
        
        //Stores events that will occur. 
        ArrayList<Events> occuringEvents = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            int roll = random.nextInt(100) + 1; // 1-100
            if (roll <= CHANCEPERDAY) {
                Events event = selectRandomEventByWeight();
                // Set all the necessary ships, etc. in the event. 
                event.initializeObjects();
                occuringEvents.add(event);

                if (game.getPlayer().checkGameStatus() == Player.GameStatus.LOSE || numEvents >= MAXEVENTS) {
                    break;
                }
            }
        }
        
        return occuringEvents;
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
