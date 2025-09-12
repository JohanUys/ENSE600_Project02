package LOGIC;

import java.util.ArrayList;

public class Ship {

    private String name;
    private int maxHoldSpace = 10;
    private ArrayList<Good> hold = new ArrayList<>();

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Good> getHold() {
        return hold;
    }

    public int getMaxHoldSpace() {
        return maxHoldSpace;
    }

    public boolean hasHoldSpace() {
        return hold.size() < maxHoldSpace;
    }

    public void load(Good good) {
        if (hasHoldSpace()) {
            hold.add(good);
        } else {
            System.out.println("No hold space to load " + good.getName());
        }
    }

    public void unload(Good good) {
        if (hold.contains(good)) {
            hold.remove(good);
        } else {
            System.out.println("Tried to unload " + good.getName() + " but it's not in the hold.");
        }
    }

    public boolean hasInHold(Good good) {
        return hold.contains(good);
    }
}
