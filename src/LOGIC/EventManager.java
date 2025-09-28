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
    
    //Determine if the chasing ship catches the chased ship.
    public static boolean chase(Ship chaserShip, Ship chasedShip)
    {
        int chaserSpeed = chaserShip.getGuns(); 
        int chasedSpeed = chasedShip.getGuns();

        int roll = random.nextInt(chaserSpeed + chasedSpeed);

        //Returns true if chased ship is caught
        return (roll < chaserSpeed);
    }
    
    public static int chaseChance(Ship chaserShip, Ship chasedShip)
    {
        int chaserSpeed = chaserShip.getMaxSpeed(); 
        int chasedSpeed = chasedShip.getMaxSpeed();
        
        double total = (double)chaserSpeed + (double)chasedSpeed;
        
        double chance = (double)chaserSpeed/total * 100;
        
        return (int)chance;
    }
    
    //Determine which ship wins in a fight 
    public static boolean fight(Ship playerShip, Ship enemyShip)
    {
        int playerPower = playerShip.getGuns(); 
        int enemyPower = enemyShip.getGuns();

        int roll = random.nextInt(playerPower + enemyPower);

        //Returns true if player ship wins
        return (roll < playerPower);
    }
    
    public static int fightChance(Ship playerShip, Ship enemyShip)
    {
        int playerGuns = playerShip.getGuns(); 
        int enemyGuns = enemyShip.getGuns();
        
        double total = (double)playerGuns + (double)enemyGuns;
        
        double chance = (double)playerGuns/total * 100;
        
        return (int)chance;
    }
    
    
    //Steal all the player's cargo and loot a certain amount of Gold. 
    public static int lootPlayer(Player player)
    {
        int goldLost = random.nextInt(30);
        if (goldLost > player.getGold()) goldLost = player.getGold();

        player.subtractGold(goldLost);
        player.getShip().getHold().clear();
        
        return goldLost;
    }
    
    public static String transfer(int index, Ship givingShip, Ship takingShip)
    {
        Good good = givingShip.getHold().get(index);
        
        if(!givingShip.hasInHold(good)) {return "ERROR: SHOULD NOT BE REACHABLE";}
        if(!takingShip.hasHoldSpace()) {return "Not enough space in the other ship for that, sorry!";}
        
        givingShip.unload(good);
        takingShip.load(good);
        
        return null;
    }
    
    public static String dump(int index, Ship dumpingShip)
    {
        Good good = dumpingShip.getHold().get(index);
        
        if(!dumpingShip.hasInHold(good)) {return "ERROR: SHOULD NOT BE REACHABLE";}
        
        dumpingShip.unload(good);
        
        return null;
    }
    
    public static Ship swapShips(Player player, Ship lootedShip)
    {
        // Store enemy ship temporarily
        Ship playerShip = player.getShip();

        // Swap the ships
        player.setShip(lootedShip);
        
        //This will be assigned to the looting ship
        return playerShip;
    }
    
    public static boolean storm(Ship playerShip)
    {
        int roll = random.nextInt(100);

        //The bigger this number, the more likely we are to sink
        int shipWeakness = playerShip.getHold().size()*5 + playerShip.getMaxSpeed();
        
        //Returns true if the ship is damaged.
        return (roll < shipWeakness);
    }
    
    public static int stormChance(Ship playerShip)
    {
        //The bigger this number, the more likely we are to sink
        return playerShip.getHold().size()*5 + playerShip.getMaxSpeed();
    }
}
