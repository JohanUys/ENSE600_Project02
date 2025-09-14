package LOGIC;

import LOGIC.ships.*;

public class Player
{
    //========== PROPERTIES ==========
    private String name;
    private int gold;
    private Ship ship;
    public enum GameStatus 
    {
        RUNNING,
        WIN,
        LOSE
    }

    //========== CONSTRUCTORS ==========
    // Default player constructor
    public Player() 
    {
        this(20, new Cutter());
    }

    public Player(int gold, Ship ship) 
    {
        this.gold = gold; 
        this.ship = ship;
    }

    //========== GETTERS AND SETTERS ==========
    public int getGold() {return this.gold;}
    public Ship getShip() {return this.ship;}
    public void setShip(Ship ship){this.ship = ship;}
    public String getName() {return this.name;}

    //========== ECONOMY HELPERS ==========
    public void addGold(int amount) 
    {
        this.gold += amount;
    }

    public void subtractGold(int amount) 
    {
        if (this.gold < amount) 
        {
            System.out.println("Not enough gold!");
            return;
        }
        this.gold -= amount;
    }

    //========== Win & Lose Conditions ==========
    // Win the game when you reach 1k gold, and lose if you have 0 gold and an empty hold
    public GameStatus checkGameStatus() 
    {
        if (gold >= 1000) 
        {
            return GameStatus.WIN;
        } 
        else if (gold == 0 && ship.getHold().isEmpty()) 
        {
            return GameStatus.LOSE;
        }
        return GameStatus.RUNNING;
    }
}