package LOGIC;

import java.util.ArrayList;
import java.util.Random;

public class Market {

    // ========== PROPERTIES ==========
    private final ArrayList<Good> goods = new ArrayList<>();
    private final int[] numStocks = new int[Good.values().length];
    private final double[] priceModifiers = new double[Good.values().length];
    private final int maxNumStock = 15;

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

    public String buy(int index, Player player) 
    {
        Good good = goods.get(index);
        int adjustedPrice = good.getAdjustedPrice(this);

        if (!stocks(good)) return "We don't sell that here!";
        if (!player.getShip().hasHoldSpace()) return "No more space in the hold, captain!";
        if (player.getGold() < adjustedPrice) return "We don't have enough gold for that!";

        player.subtractGold(adjustedPrice);
        unstock(good);
        player.getShip().load(good);

        return null;
    }

    public String sell(int index, Player player) 
    {
        Good good = player.getShip().getHold().get(index);

        if (!player.getShip().hasInHold(good)) return "We don't have any of that!";

        int adjustedPrice = good.getAdjustedPrice(this);
        player.getShip().unload(good);
        stock(good);
        player.addGold(adjustedPrice);

        return null;
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

    public final void generateStock() {
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