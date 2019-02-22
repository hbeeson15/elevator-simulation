package ElevatorSimulation;

public class Passenger {
    
    String passName;
    int enterFloor;
    int exitFloor;
    int exitTime = 0;       //times temporarily got off
    
    public Passenger(String name, int floorEntered, int floorExited ) {
        
        passName = name;
        enterFloor = floorEntered;
        exitFloor = floorExited;
    }
    
    public String getName(){
        return passName;
    }
    
    public int getEnterFloor() {
        return enterFloor;
    }
    
    public int getExitFloor(){
        return exitFloor;
    }
    
    public void increaseExitTime() {
        exitTime++;
    }
    
    public String passengerInfo() {
        return (passName + " entered: " + enterFloor + ", exited: " + exitFloor + ", temporarily got off " + exitTime + " times.");
                
    }
}