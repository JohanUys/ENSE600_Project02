package LOGIC;

//STORES ENTIRE GAME STATE
public class Game 
{
    private final Map map;
    private final Player player; 
    private final Wind wind;
    private Port port;
    
    public Game()
    {
        this.map = new Map();
        this.player = new Player();
        this.wind = new Wind();
        this.port = map.getPorts().get("Rhymek");
    }
    
    public Map getMap() {return this.map;}
    public Player getPlayer() {return this.player;}
    public Wind getWind() {return this.wind;}
    public Port getPort() {return this.port;}
    
    public void setPort(Port port) {this.port = port;}
}
