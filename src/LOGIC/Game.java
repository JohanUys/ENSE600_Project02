package LOGIC;

//STORES ENTIRE GAME STATE

import Database.WindDatabase;

public class Game 
{
    // PROPERTIES ==============================================================
    private final Map map;
    private final Player player; 
    private Wind wind;
    private Port port;
    
    // CONSTRUCTOR =============================================================
    public Game()
    {
        this.map = new Map();
        this.player = new Player();
        this.wind = new Wind(); // Default wind is overwritten
        this.port = null; // Set after load / new map
    }
    
    // GETTERS & SETTERS =======================================================
    public Map getMap() {return this.map;}
    public Player getPlayer() {return this.player;}
    public Wind getWind() {return this.wind;}
    public Port getPort() {return this.port;}

    public void setPort(Port port) {this.port = port;}


    // METHODS =================================================================
    // Ensures the map is loaded if possible, otherwise generates a new map
    public boolean initialiseMap() {
        boolean mapLoaded = map.loadOrGenerateMap();

        if (mapLoaded) {
            // Check if a wind record exists in the database
            if (WindDatabase.windExists()) {
                this.wind = WindDatabase.loadWind();
            } else {
                this.wind = new Wind();
                WindDatabase.saveWind(this.wind); // Save new wind for next time
            }
        } else {
            // Map could not be loaded, so generate new wind
            this.wind = new Wind();
            WindDatabase.saveWind(this.wind);
        }

        // Set default starting port
        this.port = map.getPorts().get("Rhymek");

        return mapLoaded;
    }

    // Forcibly generates a new map and sets the starting port.
    public void forceGenerateNewMap() {
        map.generateNewMap();
        this.wind = new Wind();
        WindDatabase.saveWind(this.wind);
        this.port = map.getPorts().get("Rhymek");
        
    }

}