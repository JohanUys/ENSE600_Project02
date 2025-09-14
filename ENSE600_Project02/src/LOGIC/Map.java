package LOGIC;

import LOGIC.ships.Ship;
import java.util.HashMap;
import java.util.Random;


public class Map
{
    //========== PROPERTIES ==========
    
    //map properties
    private final int mapSize = 1000;
    private final int[][] map = new int[mapSize][mapSize];
    
    //port properties
    private final HashMap<String,Port> ports = new HashMap<>();
    private final String[] portNames = {"Rhymek", "HavenPort", "Iglag", "Ludwig", "Port Royal"};
   
  
    // ========== CONSTRUCTOR ==========
    public Map()
    {
        generateMap();
    }
    
    //========== GETTERS AND SETTERS ==========
    public String[] getPortNames() {return this.portNames;}
    public HashMap<String,Port> getPorts() {return this.ports;}
    
    //========== METHODS ==========
    public final void generateMap()
    {
        Random random = new Random();

        //For each port
        for(String portName : portNames)
        {
            //GENERATE COORDINATES----------------------------------------------
            
            //generate location
            int latitude = random.nextInt(mapSize);
            int longitude = random.nextInt(mapSize);
            
            //check if location is reserved
            while(this.map[latitude][longitude] == 1)
            {
                latitude = random.nextInt(mapSize);
                longitude = random.nextInt(mapSize);
            }
            
            //reserve the map location
            this.map[latitude][longitude] = 1;
            
           
            //CREATE PORT-------------------------------------------------------
            Port port = new Port(portName, latitude, longitude);
            ports.put(portName, port);  
        }
    }
    
    public int calculatePortDistance(String port1, String port2)
    {
        //store coordinates of both ports
        int port1Longitude = this.ports.get(port1).getLatitude();
        int port1Latitude = this.ports.get(port1).getLongitude();
        int port2Longitude = this.ports.get(port2).getLatitude();
        int port2Latitude = this.ports.get(port2).getLongitude();
        
        //Find differences in coordinates
        double latitudeDifference = Math.abs(port1Latitude - port2Latitude);
        double longitudeDifference = Math.abs(port1Longitude - port2Longitude);
        
        //Rounded pythagorean theorum
        int distance = (int)Math.round(Math.sqrt(Math.pow(latitudeDifference, 2) + Math.pow(longitudeDifference, 2)));
        
        return distance;
    }
    
    public Direction calculatePortDirection(String port1, String port2)
    {
        //store coordinates of both ports
        int port1Longitude = this.ports.get(port1).getLatitude();
        int port1Latitude = this.ports.get(port1).getLongitude();
        int port2Longitude = this.ports.get(port2).getLatitude();
        int port2Latitude = this.ports.get(port2).getLongitude();
        
        //Find differences in coordinates
        double latitudeDifference = port2Latitude - port1Latitude;
        double longitudeDifference = port2Longitude - port1Longitude;
        
        //take inverse tangent of coordinate differences
        double angle = Math.atan2(latitudeDifference,longitudeDifference);
        
        //convert to degrees
        angle = Math.toDegrees(angle);
        
        //if angle is in the lower quadrants, convert to a positive angle from the x axis.
        if(angle<0) 
        {
            angle += 360;
        }
        
        //find the cardinal direction from the angle. This is unit circle angles, not compass angles. 
        if(67.5<=angle && angle<112.5)  {return Direction.NORTH;} //
        if(112.5<=angle && angle<157.5) {return Direction.NORTHWEST;} //
        if(157.5<=angle && angle<202.5) {return Direction.WEST;}
        if(202.5<=angle && angle<247.5) {return Direction.SOUTHWEST;}
        if(247.5<=angle && angle<292.5) {return Direction.SOUTH;}
        if(292.5<=angle && angle<337.5) {return Direction.SOUTHEAST;}
        if(337.5<=angle || angle<22.5)  {return Direction.EAST;}
        if(22.5<=angle && angle<67.5)   {return Direction.NORTHEAST;}//
        
        System.out.println("Error Finding Direction");
        System.exit(0);
        return Direction.NORTH; //should never reach this
    }
    
    public int calculatePortTravelTime(String port1, String port2 , Wind wind, Ship ship)
    {
        //CALCULATE WIND SPEED FACTOR-------------------------------------------
        
        //windspeed will be from 1-50 Knots
        double windSpeed = (double)wind.getSpeed();
        
        //Convert windspeed to percentage
        double windSpeedFactor = (windSpeed*2)/100;
        
        //CALCULATE WIND DIRECTION FACTOR---------------------------------------
        
        //Get IDs for both wind direction and port direction
        int windDirectionID = wind.getDirection().getID();
        int portDirectionID = calculatePortDirection(port1,port2).getID();
        int windDifference;
        
        //Algorithm to calculate wind direction modifier 0-4, with 0 being slowest (heading closest to wind)
        if(Math.abs(windDirectionID - portDirectionID) > 4)
        {
            windDifference = 8- Math.abs(windDirectionID-portDirectionID);
        }
        else windDifference = Math.abs(windDirectionID - portDirectionID);
        
        //Percentage of wind that will be used to sail. 
        double windDirectionFactor = 0;
        
        switch(windDifference)
        {
            case 0 -> windDirectionFactor = 0;      //Wind coming from bow
            case 1 -> windDirectionFactor = 0.25;   //Wind coming from port/starboard bow
            case 2 -> windDirectionFactor = 0.50;   //Wind coming from port/starboard
            case 3 -> windDirectionFactor = 0.75;   //Wind coming from port/starboard quarter  
            case 4 -> windDirectionFactor = 1;      //Wind coming from stern
            default -> System.out.println("Error finding windDirectionFactor");
        }
        
        //CALCULATE TRAVEL TIME-------------------------------------------------
        
        double modifiedShipSpeed = ship.getMaxSpeed()*windDirectionFactor*windSpeedFactor;
        
        if(modifiedShipSpeed == 0) {modifiedShipSpeed = 0.1;}
        
        //find the distance between the ports
        int portDistance = calculatePortDistance(port1,port2);
        
        //time (hours) = distance/speed
        return (int)(portDistance/modifiedShipSpeed);
    }
    

}
