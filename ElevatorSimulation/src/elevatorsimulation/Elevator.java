package ElevatorSimulation;

public class Elevator{
    
    Stack riders;
    Stack tempOff;       //stack of people who only get off to let others off
    int currentFloor;
    
    public void Elevator(String t) {
        riders = new Stack();
        System.out.println(t);
        tempOff = new Stack();   
    }
    
    void pushRider(Passenger p) {
             
       // currentFloor = p.getEnterFloor();
        //System.out.println(p.getEnterFloor());
        //System.out.println(riders.size);
        System.out.println(riders+ " Elevator line 19");
        if(p.getEnterFloor() == 1) {
            try{
             riders.push(p);
             System.out.println(riders.peek());
            }
            catch(Exception E){
            System.out.println(E);
        }
        }
    }
    
    boolean isFull(){
        if(riders.size == 5)
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    void nextFloor() {       //find the closest floor from the riders
        Stack copyRiders = new Stack();
        copyRiders = riders; 
        
       // for(int i = 0; i < riders.size; i++) {
            //System.out.println(riders.size);
            //System.out.println(copyRiders.size);
       // }
    }
    
    int getCurrentFloor() {
        return currentFloor;
    }
    
    void setCurrentFloor(int floor) {
        currentFloor = floor;
    }
}