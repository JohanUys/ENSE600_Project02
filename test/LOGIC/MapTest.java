
package LOGIC;

import LOGIC.ships.Cutter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MapTest
{ 
    // INITIALIZE TEST PORTS ===================================================
    // latitude (y), longitude (x)
    private final Port basePort = new Port("", 500, 500);
    
    private final Port portN = new Port("", 400,500);
    private final Port portNE = new Port("", 400,600);
    private final Port portE = new Port("", 500,600);
    private final Port portSE = new Port("", 600,600);
    private final Port portS = new Port("", 600,500);
    private final Port portSW = new Port("", 600,400);
    private final Port portW = new Port("", 500,400);
    private final Port portNW = new Port("", 400,400);
    
    // INITIALIZE WIND AND SHIP ================================================
    private final Wind wind = new Wind();
    private final Ship ship = new Cutter();
    
    @Before
    public void setup()
    {
        ship.setMaxSpeed(10); //Set ship max speed to 10 knots for testing
    }
    
    @Test
    public void testGenerateMapAllPortsGenerated()
    {
        Map map = new Map();
        
        for(String portName : map.getPortNames())
        {
            assertNotNull(map.getPorts().get(portName));
        }
    }
    
    @Test
    public void testGenerateMapAllPortsWithinLatitudeBoundaries()
    {
        Map map = new Map();
        
        for(String portName : map.getPortNames())
        {
            int latitude = map.getPorts().get(portName).getLatitude();
            assertTrue(latitude < 1000 && latitude >= 0);
        }
    }
    
    @Test
    public void testGenerateMapAllPortsWithinLongitudeBoundaries()
    {
        Map map = new Map();
        
        for(String portName : map.getPortNames())
        {
            int longitude = map.getPorts().get(portName).getLongitude();
            assertTrue(longitude < 1000 && longitude >= 0);
        }
    }
    
    @Test
    public void testGenerateMapNoPortsInSameLocation()
    {
        Map map = new Map();
        
        for(String portName1 : map.getPortNames())
        {
            int latitude1 = map.getPorts().get(portName1).getLatitude();
            int longitude1 = map.getPorts().get(portName1).getLongitude();
            
            for(String portName2 : map.getPortNames())
            {
                int latitude2 = map.getPorts().get(portName2).getLatitude();
                int longitude2 = map.getPorts().get(portName2).getLongitude();
                
                assertFalse(latitude1 == latitude2 && longitude1 == latitude2);
            }
        }
    }
    
    @Test
    public void testGenerateMapNoPortsTooClose()
    {
        Map map = new Map();
        
        for(String portName1 : map.getPortNames())
        {
            Port port1 = map.getPorts().get(portName1);
            
            for(String portName2 : map.getPortNames())
            {
                Port port2 = map.getPorts().get(portName2);
                
                if(port1 != port2)
                {
                    assertTrue(Map.calculatePortDistance(port1,port2) > 50);
                }
            }
        }
    }

    // TEST CALCULATE PORT DISTANCE ============================================
    @Test
    public void testCalculatePortDistanceN() {testDistance(100,portN);}
    @Test
    public void testCalculatePortDistanceNE() {testDistance(141,portNE);}
    @Test
    public void testCalculatePortDistanceE() {testDistance(100,portE);}
    @Test
    public void testCalculatePortDistanceSE() {testDistance(141,portSE);}
    @Test
    public void testCalculatePortDistanceS() {testDistance(100,portS);}
    @Test
    public void testCalculatePortDistanceSW() {testDistance(141,portSW);}
    @Test
    public void testCalculatePortDistanceW() {testDistance(100,portW);}
    @Test
    public void testCalculatePortDistanceNW() {testDistance(141,portNW);}
    
    private void testDistance(int expectedDistance, Port port) {
        int result = Map.calculatePortDistance(basePort, port);
        assertEquals(expectedDistance, result);
    }
    
    // TEST CALCULATE PORT DIRECTION ============================================
    @Test
    public void testCalculatePortDirectionN() {testDirection(Direction.NORTH, portN);}
    @Test
    public void testCalculatePortDirectionNE() {testDirection(Direction.NORTHEAST, portNE);}
    @Test
    public void testCalculatePortDirectionE() {testDirection(Direction.EAST, portE);}
    @Test
    public void testCalculatePortDirectionSE() {testDirection(Direction.SOUTHEAST, portSE);}
    @Test
    public void testCalculatePortDirectionS() {testDirection(Direction.SOUTH, portS);}
    @Test
    public void testCalculatePortDirectionSW() {testDirection(Direction.SOUTHWEST, portSW);}
    @Test
    public void testCalculatePortDirectionW() {testDirection(Direction.WEST, portW);}
    @Test
    public void testCalculatePortDirectionNW() {testDirection(Direction.NORTHWEST, portNW);}
    
    private void testDirection(Direction expectedDirection, Port port) {
        Direction result = Map.calculatePortDirection(basePort, port);
        assertEquals(expectedDirection, result);
    }
    
    // TEST CALCULATE PORT TRAVEL TIME =========================================
    // Expected values based on excel spreadsheet I made.
    @Test
    public void testCalculatePortTravelTime10KnotsN() {testTime(250, 10, Direction.NORTH);}
    @Test
    public void testCalculatePortTravelTime25KnotsN() {testTime(100, 25, Direction.NORTH);}
    @Test
    public void testCalculatePortTravelTime50KnotsN() {testTime(50, 50, Direction.NORTH);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsNE() {testTime(125, 10, Direction.NORTHEAST);}
    @Test
    public void testCalculatePortTravelTime25KnotsNE() {testTime(50, 25, Direction.NORTHEAST);}
    @Test
    public void testCalculatePortTravelTime50KnotsNE() {testTime(25, 50, Direction.NORTHEAST);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsE() {testTime(83, 10, Direction.EAST);}
    @Test
    public void testCalculatePortTravelTime25KnotsE() {testTime(33, 25, Direction.EAST);}
    @Test
    public void testCalculatePortTravelTime50KnotsE() {testTime(16, 50, Direction.EAST);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsSE() {testTime(62, 10, Direction.SOUTHEAST);}
    @Test
    public void testCalculatePortTravelTime25KnotsSE() {testTime(25, 25, Direction.SOUTHEAST);}
    @Test
    public void testCalculatePortTravelTime50KnotsSE() {testTime(12, 50, Direction.SOUTHEAST);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsS() {testTime(50, 10, Direction.SOUTH);}
    @Test
    public void testCalculatePortTravelTime25KnotsS() {testTime(20, 25, Direction.SOUTH);}
    @Test
    public void testCalculatePortTravelTime50KnotsS() {testTime(10, 50, Direction.SOUTH);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsSW() {testTime(62, 10, Direction.SOUTHWEST);}
    @Test
    public void testCalculatePortTravelTime25KnotsSW() {testTime(25, 25, Direction.SOUTHWEST);}
    @Test
    public void testCalculatePortTravelTime50KnotsSW() {testTime(12, 50, Direction.SOUTHWEST);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsW() {testTime(83, 10, Direction.WEST);}
    @Test
    public void testCalculatePortTravelTime25KnotsW() {testTime(33, 25, Direction.WEST);}
    @Test
    public void testCalculatePortTravelTime50KnotsW() {testTime(16, 50, Direction.WEST);}
    
    @Test
    public void testCalculatePortTravelTime10KnotsNW() {testTime(125, 10, Direction.NORTHWEST);}
    @Test
    public void testCalculatePortTravelTime25KnotsNW() {testTime(50, 25, Direction.NORTHWEST);}
    @Test
    public void testCalculatePortTravelTime50KnotsNW() {testTime(25, 50, Direction.NORTHWEST);}
    
    
    private void testTime(int expectedHours, int windSpeed, Direction direction)
    {
        wind.setSpeed(windSpeed);
        wind.setDirection(direction);
        
        int result = Map.calculatePortTravelTime(basePort, portN, wind, ship);
        System.out.println(windSpeed + " " + direction.getName() + ": " + result);
        assertEquals(expectedHours, result);
    }
}
