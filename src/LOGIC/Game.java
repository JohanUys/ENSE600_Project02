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
    // Ensures the map is loaded if possible, otherwise generates a new map.
    public boolean initialiseMap() {
        boolean mapLoaded = map.loadOrGenerateMap();

        if (mapLoaded) {
            Wind loadedWind = WindDatabase.loadWind();
            if (loadedWind != null) {
                this.wind = loadedWind;
            } else {
                this.wind = new Wind();
                WindDatabase.saveWind(this.wind);
            }
        } else {
            // No saved map, generate wind only
            this.wind = new Wind();
            WindDatabase.saveWind(this.wind);
        }

        this.port = map.getPorts().get("Rhymek");  // Default starting port
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