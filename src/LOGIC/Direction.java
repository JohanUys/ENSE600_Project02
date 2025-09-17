package LOGIC;

public enum Direction
{
    NORTH(0,"N"),NORTHEAST(1,"NE"),EAST(2,"E"),SOUTHEAST(3,"SE"),SOUTH(4,"S"),SOUTHWEST(5,"SW"),WEST(6,"W"),NORTHWEST(7,"NW");
    
    //========== PROPERTIES ==========
    private final int ID;
    private final String name;
    
    //========== CONSTRUCTOR ==========
    Direction(int ID, String acronym)
    {
        this.name = acronym;
        this.ID = ID;
    }
    
    //========== SETTERS&GETTERS ==========
    public String getName() {return this.name;}
    public int getID() {return this.ID;}
}
