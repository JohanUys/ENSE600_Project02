package LOGIC;

import java.util.ArrayList;
import java.util.Random;

public class Market {

    // ========== PROPERTIES ==========
    private final ArrayList<Good> goods = new ArrayList<>();
    private final int[] numStocks = new int[Good.values().length];
    private final double[] priceModifiers = new double[Good.values().length];
    private final int maxNumStock = 4;

    private final String portName;

    // ========== CONSTRUCTOR ==========
    public Market(String portName) {
        this.portName = portName;
        generateStock();
        generatePriceModifiers();
    }

    // ========== GETTERS ==========
    public double[] getPriceModifiers() {return this.priceModifiers;}
    public ArrayList<Good> getGoods() {return this.goods;}
    public int[] getNumStocks() {return this.numStocks;}
    public String getPortName() {return this.portName;}

    // ========== BUY/SELL METHODS ==========

    public boolean buy(Player player, String input) {
        try {
            Good good = Good.valueOf(input.toUpperCase());
            int adjustedPrice = good.getAdjustedPrice(this);

            if (!stocks(good)) return false;
            if (!player.getShip().hasHoldSpace()) return false;
            if (player.getGold() < adjustedPrice) return false;

            player.subtractGold(adjustedPrice);
            unstock(good);
            player.getShip().load(good);

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean sell(Player player, String input) {
        try {
            Good good = Good.valueOf(input.toUpperCase());

            if (!player.getShip().hasInHold(good)) return false;

            int adjustedPrice = good.getAdjustedPrice(this);
            player.getShip().unload(good);
            stock(good);
            player.addGold(adjustedPrice);

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // ========== STOCK CONTROL ==========

    public void stock(Good good) {
        this.goods.add(good);
        this.numStocks[good.getID()]++;
    }

    public void unstock(Good good) {
        if (stocks(good)) {
            this.goods.remove(good);
            this.numStocks[good.getID()]--;
        }
    }

    public boolean stocks(Good good) {
        return this.goods.contains(good);
    }

    public void generateStock() {
        goods.clear();

        Random random = new Random();

        for (Good g : Good.values()) {
            int numStock = random.nextInt(maxNumStock) + 1;
            numStocks[g.getID()] = numStock;

            for (int i = 0; i < numStock; i++) {
                stock(g);
            }
        }
    }

    private void generatePriceModifiers() {
        Random random = new Random();

        for (Good g : Good.values()) {
            double priceModifier = random.nextInt(101); // 0 to 100%
            priceModifiers[g.getID()] = priceModifier;
        }
    }

    // ========== DEBUGGING / DISPLAY ==========

    public void displayMarket() {
        System.out.println("Market at: " + portName);
        for (Good g : Good.values()) {
            int stock = numStocks[g.getID()];
            int price = g.getAdjustedPrice(this);
            System.out.println(g.getName() + " — Price: " + price + " — Stock: " + stock);
        }
    }
}