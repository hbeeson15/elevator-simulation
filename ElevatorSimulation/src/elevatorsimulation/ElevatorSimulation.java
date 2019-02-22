package ElevatorSimulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;

/**
 *
 * @author Holly Beeson
 * Date: October 2, 2018
 * Data Structures 
 * Elevator Simulation Lab
 */

public class ElevatorSimulation {

    public static void main(String[] args) {
        
       Passenger[] passengers = new Passenger[50];
       Stack mainStack = ReadFile("data.csv", passengers);
       //Elevator e = new Elevator("test");
       Stack elevator = new Stack();
       int currentFloor = 1; 
       
      elevator = pushRider(mainStack, elevator, currentFloor);
       System.out.println(elevator.size);
       System.out.println(elevator.peek().passName);
       System.out.println(currentFloor);
       currentFloor = nextFloor(mainStack, elevator, currentFloor);
       System.out.println(currentFloor);
       
       while(!mainStack.isEmpty()) {
          
           System.out.println(mainStack.size);
           System.out.println(elevator.isEmpty());
           //elevator = popRider(elevator, currentFloor);
           //elevator = pushRider(mainStack, elevator, currentFloor);
           elevator = popRider(pushRider(mainStack,elevator,currentFloor), currentFloor);
           //currentFloor = nextFloor(mainStack, elevator, currentFloor);
       }
       
       /*pushRider(mainStack, elevator, currentFloor);
       System.out.println(elevator.size);
       popRider(elevator, currentFloor);/*
       
       
       
    
       
       /*for(int i = 0; i < 5; i++) {
           elevator.push(mainStack.pop());
       }
       System.out.println(elevator.size);*/
       
       //System.out.println(mainStack.peek().passName);
       //System.out.println(mainStack.size);
       //System.out.println(mainStack + " main line 25");

       //System.out.println(mainStack.pop().passName);
      // for(int i = 1; i < 2; i++) {
          //if(mainStack.peek()!=null){
            //e.pushRider(mainStack.pop());
            //e.pushRider(mainStack.pop());
           //e.pushRider(mainStack.pop());
           //e.pushRider(mainStack.pop());
           //e.pushRider(mainStack.pop());
           
         // }
         
         //System.out.println(mainStack.pop().passName);
       //  e.nextFloor();
         
       //}
}
 
 private static Stack pushRider(Stack main, Stack elev, int floor) {
     while(main.peek().getEnterFloor() == floor && elev.size < 5) {
         elev.push(main.pop());
         System.out.println(elev.pop().passName);
     }
     return elev;
 }
 
 private static Stack popRider(Stack elev, int floor) {
     System.out.println(elev.top);
     Stack tempOff = new Stack();
     for(int i = 0; i < elev.size; i++) {
        System.out.println(elev.size);
        System.out.println("test");
        if(elev.peek().getExitFloor() == floor) {
            System.out.println(elev.peek().passengerInfo());
            elev.pop();
        }
        else {
           elev.peek().increaseExitTime();
           System.out.println(elev.peek().passName);
           tempOff.push(elev.pop());
           System.out.println(tempOff.peek().passName + " line 97");
//           System.out.println(elev.top.next);
        }
     }
     for(int i = 0; i < tempOff.size; i++ ) {
         elev.push(tempOff.pop());
     }
     return elev;
 }
          
 private static int nextFloor(Stack main, Stack elev, int floor) {
     int[] r = new int[elev.size + 1];
     for(int i = 0; i < elev.size; i++ ) {
         r[i] = elev.pop().getExitFloor();
     }
    if(elev.size != 5) {
        r[elev.size] = main.pop().getExitFloor();
    }
    
    for(int i = 1; i < r.length; i++) {
        for(int j = 0; j < r.length; j++) {
            if(java.lang.Math.abs(floor - r[j]) == i) {
               // System.out.println("Should return");
                return r[j];
        }
            //System.out.println(floor - r[j]);
      }
    }
    return 0;
 }
 
 private static Stack ReadFile(String fileName, Passenger[] p) {                //this function reads in the input data file
        
        BufferedReader stream = null;
        String line = null;
        int iter = 49;
        
        try {
            stream = new BufferedReader(new FileReader (fileName));
            while((line = stream.readLine()) != null) {
               String[] split = line.split(",");
               p[iter] = (new Passenger(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
               iter--;     //puts data from file into an array backwards
               //System.out.println(p[iter+1].passName);
            } 
            stream.close();
            
            Stack people = new Stack();
            for(int i = 0; i < p.length; i++) {
                if(p[i] !=null){
                people.push(p[i]);                   
                }

            } 
            //System.out.println(people.peek().getName());
            return people;
            
        } catch (IOException ioe) {
            return new Stack(); 
        }
    } 
}