package ElevatorSimulation;

public class Stack {
    SNode top;
    int size;       //size parameter
     
    public void Stack(){
        System.out.println("stack initiallized");
        top = new SNode();
        top.pass = new Passenger("test",1,0);
        size = 0;       
    }
    
    public boolean isEmpty() {
        if (top == null) {
            return true;
        } 
        else {
            return false;
        }
    }
    
    public void push(Passenger p){
        SNode temp = new SNode(/*p, top*/);     //allocate space for new passenger, pass in the info and make it the top of the stack
        temp.pass = p; 
        temp.next = top;
        top = temp;              //reset top pointer
        size++;                 
    }
    
    public Passenger pop() {
        Passenger p;
        SNode temp = new SNode(/*top.pass, top.next*/);
        if(isEmpty() == true){
            System.out.println("ERROR: stack empty");
            return null;
        }
        else {
            p = top.pass;       //take out info
            //System.out.println(top.next + "stack line 37");
            top = top.next;     //reset stack top
            //System.out.println(top.next + "stack line 39");
            temp.next = null;   //disconnect node
            temp.pass = new Passenger(" ", 0, 0);
            return p;           //return popped item
        }
    }
    
    public Passenger peek() {
        //System.out.println(top.pass.passName);
        return top.pass;
    }
}

class SNode {
   public Passenger pass;
   public SNode next;
    
    public SNode(/*Passenger p, SNode n1*/) {
        //pass = p;
        //next = n1;
    }
}