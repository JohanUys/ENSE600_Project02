package LOGIC;

public enum Good {

    // ========== ENUM VALUES ==========
    GRAIN(0, "Grain", 10),
    BEEF(1, "Beef", 15),
    TIMBER(2, "Timber", 20),
    IRON(3, "Iron", 30),
    SILK(4, "Silk", 40);

    // ========== PROPERTIES ==========
    private final int ID;
    private final String name;
    private final double maxPrice;

    // ========== CONSTRUCTOR ==========
    Good(int ID, String name, double maxPrice) {
        this.ID = ID;
        this.name = name;
        this.maxPrice = maxPrice;
    }

    // ========== GETTERS ==========
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    // ========== METHODS ==========

    // Calculates adjusted price based on port market modifiers
    public int getAdjustedPrice(Market market) {
        double modifier = market.getPriceModifiers()[this.ID]; // e.g. 75 = 75%
        int adjustedPrice = (int)(this.maxPrice * (modifier / 100.0)); // ← fix: use 100.0 to avoid integer division

        if (adjustedPrice <= 0) {
            adjustedPrice = 1;
        }

        return adjustedPrice;
    }

    // For debugging / CLI
    public void displayGood(Market market) {
        int adjustedPrice = getAdjustedPrice(market);
        System.out.println(this.name + " : " + adjustedPrice + " (Max Price: " + (int)this.maxPrice + ")");
    }
}