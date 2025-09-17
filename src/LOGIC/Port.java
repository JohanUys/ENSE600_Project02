package LOGIC;

public class Port
{ 
    //========== PROPERTIES ==========
    private final String name;
    private final int longitude;
    private final int latitude;
    private final Market market;
    private final Shipyard shipyard;
    
    //========== CONSTRUCTOR ==========
    public Port(String name, int latitude, int longitude) 
    {
        this.name = name;
        
        //Set coordinates
        this.latitude = latitude;
        this.longitude = longitude;
        
        //Initialize market & shipyard
        this.market = new Market(name);
        this.shipyard = new Shipyard(name);
    }
    
    //========== GETTERS&SETTERS ==========
    public String getName() {return this.name;}
    public int getLongitude() {return this.latitude;}
    public int getLatitude() {return this.longitude;}
    public Market getMarket() {return this.market;}
    public Shipyard getShipyard() {return this.shipyard;}
    
    //========== METHODS ================
    
    public void resetMarket()
    {
        this.market.generateStock();
    }
}