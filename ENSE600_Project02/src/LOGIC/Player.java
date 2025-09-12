package LOGIC;

public class Player {

    private int gold;
    private String name;
    private Ship ship;

    public Player() {
        this.gold = 20;
        this.ship = new Ship("Default Ship");
    }

    public int getGold() {
        return gold;
    }

    public String getName() {
        return name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public void subtractGold(int amount) {
        this.gold -= amount;
    }
}
